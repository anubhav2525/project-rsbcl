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
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

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

    public Response<Employee> getEmployeeByEmail(String email) {
        try {
            Employee employee = employeeRepo.findByEmail(email).orElse(null);
            if (employee != null) return new Response<>("Success", "Employee exists", employee);
            return new Response<>("Error404", "Employee not exists", null);
        } catch (Exception e) {
            return new Response<>("Error", e.getMessage(), null);
        }
    }

    public Response<Employee> getEmployeeByUsername(String username) {
        try {
            Employee employee = employeeRepo.findByUsername(username).orElse(null);
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

    //    save employee
    @Transactional
    public Response<Employee> saveEmployee(Employee employee) {
        try {
            // role verification
            List<Boolean> roleVerification = new ArrayList<>();

            // get roles from the new employee
            List<String> roles = employee.getRoles();
            for (String role : roles) {
                roleVerification.add(rolesService.roleExists(role));
            }
            if (roleVerification.contains(false))
                return new Response<>("Error404", "Data error roles not match", employee);

            // department verification
            boolean departmentVerification = departmentService.departmentExists(employee.getDepartmentName());
            if (!departmentVerification) return new Response<>("Error404", "Data error department not match", employee);

            // username verification
            boolean usernameVerification = usersService.usernameExists(employee.getUsername());
            if (usernameVerification)
                return new Response<>("Error208", "Data error username already exists change it", employee);

            // if all correct then save employee
            employee.setLastUpdated(LocalDateTime.now());
            Employee savedEmployee = employeeRepo.save(employee); // saving new employee

            // user save
            String randomPassword = randomPasswordGenerator.generateRandomPassword();
            EmployeeService.UserGenerator userGenerator = new EmployeeService.UserGenerator();
            userGenerator.setEmployeeId(savedEmployee.getId());
            userGenerator.setUsername(savedEmployee.getUsername());
            userGenerator.setPassword(randomPassword);
            userGenerator.setRoles(savedEmployee.getRoles());
            userGenerator.setLastUpdate(LocalDateTime.now());
            usersService.saveUser(userGenerator); // saving the new employee users details

            // email sent code
            EmailService.Response<Void> response = emailService.sendEmail(employee.getEmail(), "Welcome to the " + employee.getDepartmentName() + " !", "Dear " + employee.getFirstName() + ", Welcome to the company!" + " Here are your login details: username : " + employee.getUsername() + ": password : " + randomPassword + "   " + "Please keep this information secure." + "Best regards, Company HR");
            if (Objects.equals(response.getStatus(), "Success")) {
                return new Response<>("Success", "Employee saved successfully and a mail sent to employee registered email", savedEmployee);
            }

            return new Response<>("Success", "Employee saved successfully but email could not be send please check it", savedEmployee);
        } catch (Exception e) {
            return new Response<>("Error", e.getMessage(), null);
        }
    }

    @Transactional
    public Response<Employee> updateEmployeeById(ObjectId id, Employee employee) {
        try {
            AtomicReference<Boolean> emailChanged = new AtomicReference<>(false);
            Boolean emailChangeValue = emailChanged.get();
            return employeeRepo.findById(id).map(oldEmployee -> {
                if (employee.getFirstName() != null && !employee.getFirstName().isEmpty()) {
                    oldEmployee.setFirstName(employee.getFirstName());
                }
                if (employee.getLastName() != null && !employee.getLastName().isEmpty()) {
                    oldEmployee.setLastName(employee.getLastName());
                }
                if (employee.getGender() != null && !employee.getGender().isEmpty()) {
                    oldEmployee.setGender(employee.getGender());
                }
                if (employee.getDateOfBirth() != null && !employee.getDateOfBirth().isEmpty()) {
                    oldEmployee.setDateOfBirth(employee.getDateOfBirth());
                }
                if (employee.getAadharNumber() != null && !employee.getAadharNumber().isEmpty()) {
                    oldEmployee.setAadharNumber(employee.getAadharNumber());
                }
                if (employee.getPhoneNumber() != null && !employee.getPhoneNumber().isEmpty()) {
                    oldEmployee.setPhoneNumber(employee.getPhoneNumber());
                }
                if (employee.getEmail() != null && !employee.getEmail().isEmpty()) {
                    emailChanged.set(true);
                    oldEmployee.setEmail(employee.getEmail());
                }
                if (employee.getAddress() != null) {
                    oldEmployee.setAddress(employee.getAddress());
                }
                if (employee.getDateOfJoining() != null && !employee.getDateOfJoining().isEmpty()) {
                    oldEmployee.setDateOfJoining(employee.getDateOfJoining());
                }
                if (employee.getJobTitle() != null && !employee.getJobTitle().isEmpty()) {
                    oldEmployee.setJobTitle(employee.getJobTitle());
                }
                if (employee.getSalary() != null) {
                    oldEmployee.setSalary(employee.getSalary());
                }
                if (employee.getEmploymentType() != null && !employee.getEmploymentType().isEmpty()) {
                    oldEmployee.setEmploymentType(employee.getEmploymentType());
                }
                if (employee.getCreatedBy() != null && !employee.getCreatedBy().isEmpty()) {
                    oldEmployee.setCreatedBy(employee.getCreatedBy());
                }
                oldEmployee.setStatus(employee.isStatus());
                oldEmployee.setLastUpdated(LocalDateTime.now());
                if (employee.getUsername() != null && !employee.getUsername().isEmpty()) {
                    oldEmployee.setUsername(employee.getUsername());
                }
                if (employee.getRoles() != null && !employee.getRoles().isEmpty()) {
                    oldEmployee.setRoles(employee.getRoles());
                }
                if (employee.getDepartmentName() != null && !employee.getDepartmentName().isEmpty()) {
                    oldEmployee.setDepartmentName(employee.getDepartmentName());
                }

                employeeRepo.save(oldEmployee); // update user to db
                if (emailChangeValue) {
                    // email sent code
                    EmailService.Response<Void> response = emailService.sendEmail(employee.getEmail(), "Your information has been changed for department : " + employee.getDepartmentName() + " !", "Dear " + employee.getFirstName() + ", Your information has been changed in the " + employee.getDepartmentName() + " Here are your new login details: username : " + employee.getUsername() + "   " + "Please keep this information secure." + "Best regards, Company HR");
                    if (Objects.equals(response.getStatus(), "Success")) {
                        return new Response<>("Success", "Employee updated successfully and a mail sent to employee registered email", oldEmployee);
                    }
                    return new Response<>("Success", "Employee updated successfully but email could not be send please check it", oldEmployee);
                }
                return new Response<>("Success", "Employee updated successfully", oldEmployee);
            }).orElseGet(() -> new Response<>("Error404", "Employee not found", null));
        } catch (Exception e) {
            return new Response<>("Error", e.getMessage(), null);
        }
    }

    @Transactional
    public Response<Employee> updateEmployeeByUsername(String username, Employee employee) {
        try {
            AtomicReference<Boolean> emailChanged = new AtomicReference<>(false);
            Boolean emailChangeValue = emailChanged.get();
            return employeeRepo.findByUsername(username).map(oldEmployee -> {
                if (employee.getFirstName() != null && !employee.getFirstName().isEmpty()) {
                    oldEmployee.setFirstName(employee.getFirstName());
                }
                if (employee.getLastName() != null && !employee.getLastName().isEmpty()) {
                    oldEmployee.setLastName(employee.getLastName());
                }
                if (employee.getGender() != null && !employee.getGender().isEmpty()) {
                    oldEmployee.setGender(employee.getGender());
                }
                if (employee.getDateOfBirth() != null && !employee.getDateOfBirth().isEmpty()) {
                    oldEmployee.setDateOfBirth(employee.getDateOfBirth());
                }
                if (employee.getAadharNumber() != null && !employee.getAadharNumber().isEmpty()) {
                    oldEmployee.setAadharNumber(employee.getAadharNumber());
                }
                if (employee.getPhoneNumber() != null && !employee.getPhoneNumber().isEmpty()) {
                    oldEmployee.setPhoneNumber(employee.getPhoneNumber());
                }
                if (employee.getEmail() != null && !employee.getEmail().isEmpty()) {
                    emailChanged.set(true);
                    oldEmployee.setEmail(employee.getEmail());
                }
                if (employee.getAddress() != null) {
                    oldEmployee.setAddress(employee.getAddress());
                }
                if (employee.getDateOfJoining() != null && !employee.getDateOfJoining().isEmpty()) {
                    oldEmployee.setDateOfJoining(employee.getDateOfJoining());
                }
                if (employee.getJobTitle() != null && !employee.getJobTitle().isEmpty()) {
                    oldEmployee.setJobTitle(employee.getJobTitle());
                }
                if (employee.getSalary() != null) {
                    oldEmployee.setSalary(employee.getSalary());
                }
                if (employee.getEmploymentType() != null && !employee.getEmploymentType().isEmpty()) {
                    oldEmployee.setEmploymentType(employee.getEmploymentType());
                }
                if (employee.getCreatedBy() != null && !employee.getCreatedBy().isEmpty()) {
                    oldEmployee.setCreatedBy(employee.getCreatedBy());
                }
                oldEmployee.setStatus(employee.isStatus());
                oldEmployee.setLastUpdated(LocalDateTime.now());
                if (employee.getUsername() != null && !employee.getUsername().isEmpty()) {
                    oldEmployee.setUsername(employee.getUsername());
                }
                if (employee.getRoles() != null && !employee.getRoles().isEmpty()) {
                    oldEmployee.setRoles(employee.getRoles());
                }
                if (employee.getDepartmentName() != null && !employee.getDepartmentName().isEmpty()) {
                    oldEmployee.setDepartmentName(employee.getDepartmentName());
                }

                employeeRepo.save(oldEmployee); // update user to db
                if (emailChangeValue) {
                    // email sent code
                    EmailService.Response<Void> response = emailService.sendEmail(employee.getEmail(), "Your information has been changed for department : " + employee.getDepartmentName() + " !", "Dear " + employee.getFirstName() + ", Your information has been changed in the " + employee.getDepartmentName() + " Here are your new login details: username : " + employee.getUsername() + "   " + "Please keep this information secure." + "Best regards, Company HR");
                    if (Objects.equals(response.getStatus(), "Success")) {
                        return new Response<>("Success", "Employee updated successfully and a mail sent to employee registered email", oldEmployee);
                    }
                    return new Response<>("Success", "Employee updated successfully but email could not be send please check it", oldEmployee);
                }
                return new Response<>("Success", "Employee updated successfully", oldEmployee);
            }).orElseGet(() -> new Response<>("Error404", "Employee not found", null));
        } catch (Exception e) {
            return new Response<>("Error", e.getMessage(), null);
        }
    }

    @Transactional
    public Response<Employee> updateEmployeeByEmail(String email, Employee employee) {
        try {
            AtomicReference<Boolean> emailChanged = new AtomicReference<>(false);
            Boolean emailChangeValue = emailChanged.get();
            return employeeRepo.findByEmail(email).map(oldEmployee -> {
                if (employee.getFirstName() != null && !employee.getFirstName().isEmpty()) {
                    oldEmployee.setFirstName(employee.getFirstName());
                }
                if (employee.getLastName() != null && !employee.getLastName().isEmpty()) {
                    oldEmployee.setLastName(employee.getLastName());
                }
                if (employee.getGender() != null && !employee.getGender().isEmpty()) {
                    oldEmployee.setGender(employee.getGender());
                }
                if (employee.getDateOfBirth() != null && !employee.getDateOfBirth().isEmpty()) {
                    oldEmployee.setDateOfBirth(employee.getDateOfBirth());
                }
                if (employee.getAadharNumber() != null && !employee.getAadharNumber().isEmpty()) {
                    oldEmployee.setAadharNumber(employee.getAadharNumber());
                }
                if (employee.getPhoneNumber() != null && !employee.getPhoneNumber().isEmpty()) {
                    oldEmployee.setPhoneNumber(employee.getPhoneNumber());
                }
                if (employee.getEmail() != null && !employee.getEmail().isEmpty()) {
                    emailChanged.set(true);
                    oldEmployee.setEmail(employee.getEmail());
                }
                if (employee.getAddress() != null) {
                    oldEmployee.setAddress(employee.getAddress());
                }
                if (employee.getDateOfJoining() != null && !employee.getDateOfJoining().isEmpty()) {
                    oldEmployee.setDateOfJoining(employee.getDateOfJoining());
                }
                if (employee.getJobTitle() != null && !employee.getJobTitle().isEmpty()) {
                    oldEmployee.setJobTitle(employee.getJobTitle());
                }
                if (employee.getSalary() != null) {
                    oldEmployee.setSalary(employee.getSalary());
                }
                if (employee.getEmploymentType() != null && !employee.getEmploymentType().isEmpty()) {
                    oldEmployee.setEmploymentType(employee.getEmploymentType());
                }
                if (employee.getCreatedBy() != null && !employee.getCreatedBy().isEmpty()) {
                    oldEmployee.setCreatedBy(employee.getCreatedBy());
                }
                oldEmployee.setStatus(employee.isStatus());
                oldEmployee.setLastUpdated(LocalDateTime.now());
                if (employee.getUsername() != null && !employee.getUsername().isEmpty()) {
                    oldEmployee.setUsername(employee.getUsername());
                }
                if (employee.getRoles() != null && !employee.getRoles().isEmpty()) {
                    oldEmployee.setRoles(employee.getRoles());
                }
                if (employee.getDepartmentName() != null && !employee.getDepartmentName().isEmpty()) {
                    oldEmployee.setDepartmentName(employee.getDepartmentName());
                }

                employeeRepo.save(oldEmployee); // update user to db
                if (emailChangeValue) {
                    // email sent code
                    EmailService.Response<Void> response = emailService.sendEmail(employee.getEmail(), "Your information has been changed for department : " + employee.getDepartmentName() + " !", "Dear " + employee.getFirstName() + ", Your information has been changed in the " + employee.getDepartmentName() + " Here are your new login details: username : " + employee.getUsername() + "   " + "Please keep this information secure." + "Best regards, Company HR");
                    if (Objects.equals(response.getStatus(), "Success")) {
                        return new Response<>("Success", "Employee updated successfully and a mail sent to employee registered email", oldEmployee);
                    }
                    return new Response<>("Success", "Employee updated successfully but email could not be send please check it", oldEmployee);
                }
                return new Response<>("Success", "Employee updated successfully", oldEmployee);
            }).orElseGet(() -> new Response<>("Error404", "Employee not found", null));
        } catch (Exception e) {
            return new Response<>("Error", e.getMessage(), null);
        }
    }

    @Transactional
    public Response<Void> deleteEmployeeByEmail(String email) {
        try {
            Employee employee = employeeRepo.findByEmail(email).orElse(null);
            if (employee != null) {
                employeeRepo.deleteByEmail(email);
                usersService.deleteByUsername(employee.getUsername());

                // email sent code
                EmailService.Response<Void> response = emailService.sendEmail(employee.getEmail(), "Your information has been removed for department : " + employee.getDepartmentName() + " !", "Dear " + employee.getFirstName() + ", Your information has been removed in the " + employee.getDepartmentName() + ". Now YOu can not able to login. " + "Best regards, Company HR");
                if (Objects.equals(response.getStatus(), "Success")) {
                    return new Response<>("Success", "Employee removed successfully and a mail sent to employee registered email", null);
                }
                return new Response<>("Success", "Employee removed successfully but email could not be send please check it", null);
            }
            return new Response<>("Error404", "Employee not found", null);
        } catch (Exception e) {
            return new Response<>("Error", e.getMessage(), null);
        }
    }

    @Transactional
    public Response<Void> deleteEmployeeByUsername(String username) {
        try {
            Employee employee = employeeRepo.findByUsername(username).orElse(null);
            if (employee != null) {
                employeeRepo.deleteByUsername(username);
                usersService.deleteByUsername(employee.getUsername());
                // email sent code
                EmailService.Response<Void> response = emailService.sendEmail(employee.getEmail(), "Your information has been removed for department : " + employee.getDepartmentName() + " !", "Dear " + employee.getFirstName() + ", Your information has been removed in the " + employee.getDepartmentName() + ". Now YOu can not able to login. " + "Best regards, Company HR");
                if (Objects.equals(response.getStatus(), "Success")) {
                    return new Response<>("Success", "Employee removed successfully and a mail sent to employee registered email", null);
                }
                return new Response<>("Success", "Employee removed successfully but email could not be send please check it", null);
            }
            return new Response<>("Error404", "Employee not found", null);
        } catch (Exception e) {
            return new Response<>("Error", e.getMessage(), null);
        }
    }

    @Transactional
    public Response<Void> deleteEmployeeById(ObjectId id) {
        try {
            Employee employee = employeeRepo.findById(id).orElse(null);
            if (employee != null) {
                employeeRepo.deleteById(id);
                usersService.deleteByUsername(employee.getUsername());
                // email sent code
                EmailService.Response<Void> response = emailService.sendEmail(employee.getEmail(), "", "");
                if (Objects.equals(response.getStatus(), "Success")) {
                    return new Response<>("Success", "Employee removed successfully and a mail sent to employee registered email", null);
                }
                return new Response<>("Success", "Employee removed successfully but email could not be send please check it", null);
            }
            return new Response<>("Error404", "Employee not found", null);
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