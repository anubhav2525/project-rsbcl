package org.excise.rsbcl.services.employee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.excise.rsbcl.model.employee.Employee;
import org.excise.rsbcl.repository.employee.EmployeeRepo;
import org.excise.rsbcl.services.emailService.EmailService;
import org.excise.rsbcl.services.employee.department.DepartmentService;
import org.excise.rsbcl.services.employee.roles.RolesService;
import org.excise.rsbcl.services.employee.users.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private final EmployeeRepo employeeRepo;
    @Autowired
    private final RolesService rolesService;
    @Autowired
    private final DepartmentService departmentService;
    @Autowired
    private final UsersService usersService;
    @Autowired
    private final RandomPasswordGenerator randomPasswordGenerator;
    @Autowired
    private final EmailService emailService;

    public EmployeeService(EmployeeRepo employeeRepo, RolesService rolesService, DepartmentService departmentService, UsersService usersService, RandomPasswordGenerator randomPasswordGenerator, EmailService emailService) {
        this.employeeRepo = employeeRepo;
        this.rolesService = rolesService;
        this.departmentService = departmentService;
        this.usersService = usersService;
        this.randomPasswordGenerator = randomPasswordGenerator;
        this.emailService = emailService;
    }

    // checking existence of username
    public boolean emailExists(String email) {
        return employeeRepo.findByEmail(email).isPresent();
    }

    public Response<List<Employee>> getAllEmployees() {
        try {
            List<Employee> employees = employeeRepo.findAll();
            if (employees.isEmpty()) return new Response<>("Error404", "Employees not exists", null);
            return new Response<>("Success", "Employees are exists", employees);
        } catch (Exception e) {
            return new Response<>("Error", e.getMessage(), null);
        }
    }

    public Response<Employee> getEmployeeById(ObjectId id) {
        try {
            Employee employee = employeeRepo.findById(id).orElse(null);
            if (employee != null) return new Response<>("Success", "Employee exists", employee);
            return new Response<>("Error404", "Employee not exists", null);
        } catch (Exception e) {
            return new Response<>("Error", e.getMessage(), null);
        }
    }

    public Response<Page<Employee>> getEmployees(int page, int size) {
        try {
            Page<Employee> employees = employeeRepo.findAll(PageRequest.of(page, size));
            return new Response<>("Success", "Employees found", employees);
        } catch (Exception e) {
            return new Response<>("Error", "Employees not found", null);
        }
    }

    @Transactional
    public Response<?> saveEmployee(Employee employee) {
        try {
            // Role verification
            List<Boolean> roleVerification = new ArrayList<>();
            List<String> roles = employee.getRoles();
            for (String role : roles) {
                roleVerification.add(rolesService.roleExists(role));
            }
            if (roleVerification.contains(false)) {
                return new Response<>("Error404", "Data error: roles not match", employee);
            }

            // Department verification
            boolean departmentVerification = departmentService.departmentExists(employee.getDepartmentName());
            if (!departmentVerification) {
                return new Response<>("Error404", "Data error: department not match", employee);
            }

            // Username verification
            boolean usernameVerification = usersService.usernameExists(employee.getUsername());
            if (usernameVerification) {
                return new Response<>("Error208", "Data error: username already exists, please change it", employee);
            }

            // email verification
            boolean emailVerification = emailExists(employee.getEmail());
            if (emailVerification) {
                return new Response<>("Error208", "Data error: email already exists, please change it", employee);
            }

            // Set the last updated time for the employee DAO
            employee.setLastUpdated(LocalDateTime.now());

            // Save the employee entity to the repository
            Employee savedEmployee = employeeRepo.save(employee);

            // Generate user for the saved employee
            String randomPassword = randomPasswordGenerator.generateRandomPassword();
            EmployeeService.UserGenerator userGenerator = new EmployeeService.UserGenerator();
            userGenerator.setEmployeeId(savedEmployee.getId());
            userGenerator.setUsername(savedEmployee.getUsername());
            userGenerator.setPassword(randomPassword);
            userGenerator.setRoles(savedEmployee.getRoles());
            userGenerator.setLastUpdate(LocalDateTime.now());

            // Save user information
            usersService.saveUser(userGenerator);

            // Send welcome email to the employee
            EmailService.Response<Void> response = emailService.sendEmail(savedEmployee.getEmail(), "Welcome to the " + savedEmployee.getDepartmentName() + "!", "Dear " + savedEmployee.getFirstName() + ",\n" + "Welcome to the company! Here are your login details:\n" + "Username: " + savedEmployee.getUsername() + "\n" + "Password: " + randomPassword + "\n\n" + "Please keep this information secure.\n" + "Best regards,\nCompany HR");

            if ("Success".equals(response.getStatus())) {
                return new Response<>("Success", "Employee saved successfully and a mail was sent to the registered email", savedEmployee);
            } else {
                return new Response<>("Success", "Employee saved successfully but email could not be sent. Please check it.", savedEmployee);
            }
        } catch (Exception e) {
            return new Response<>("Error", e.getMessage(), null);
        }
    }

    // Response static class
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response<T> {
        private String status;
        private String message;
        private T data;
    }

    // user dao
    @Setter
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserGenerator {
        private String username;
        private String password;
        private ObjectId employeeId;
        private List<String> roles;
        private LocalDateTime lastUpdate;
    }
}