package org.excise.rsbcl.controllers.employee;

import jakarta.validation.Valid;
import org.bson.types.ObjectId;
import org.excise.rsbcl.model.employee.Employee;
import org.excise.rsbcl.services.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/v1/auth/employees")
    public ResponseEntity<?> getAllEmployees() {
        EmployeeService.Response<List<Employee>> responses = employeeService.getAllEmployees();
        return createResponseEntity(responses);
    }

    @GetMapping("/v1/auth/employee/id/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable("id") ObjectId id) {
        EmployeeService.Response<Employee> response = employeeService.getEmployeeById(id);
        return createResponseEntity(response);
    }

    @GetMapping("/v1/auth/employee/username/{username}")
    public ResponseEntity<?> getEmployeeByUsername(@PathVariable("username") String username) {
        EmployeeService.Response<Employee> response = employeeService.getEmployeeByUsername(username);
        return createResponseEntity(response);
    }

    @GetMapping("/v1/auth/employee/email/{email}")
    public ResponseEntity<?> getEmployeeByEmail(@PathVariable("email") String email) {
        EmployeeService.Response<Employee> response = employeeService.getEmployeeByEmail(email);
        return createResponseEntity(response);
    }

    @PostMapping("/v1/auth/employee")
    public ResponseEntity<?> saveEmployee(@Valid @RequestBody Employee employee, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }
        EmployeeService.Response<?> response = employeeService.saveEmployee(employee);
        return createResponseEntity(response);
    }

    @PutMapping("/v1/auth/employee/username/{username}")
    public ResponseEntity<?> updateEmployeeByUsername(@PathVariable("username") String username, @RequestBody Employee employee) {
        EmployeeService.Response<Employee> response = employeeService.updateEmployeeByUsername(username, employee);
        return createResponseEntity(response);
    }

    @PutMapping("/v1/auth/employee/id/{id}")
    public ResponseEntity<?> updateEmployeeById(@PathVariable("id") ObjectId id, @RequestBody Employee employee) {
        EmployeeService.Response<Employee> response = employeeService.updateEmployeeById(id, employee);
        return createResponseEntity(response);
    }

    @PutMapping("/v1/auth/employee/email/{email}")
    public ResponseEntity<?> updateEmployeeByEmail(@PathVariable("email") String email, @RequestBody Employee employee) {
        EmployeeService.Response<Employee> response = employeeService.updateEmployeeByEmail(email, employee);
        return createResponseEntity(response);
    }

    @DeleteMapping("/v1/auth/employee/id/{id}")
    public ResponseEntity<?> deleteEmployeeById(@PathVariable("id") ObjectId id) {
        EmployeeService.Response<Void> response = employeeService.deleteEmployeeById(id);
        return createResponseEntity(response);
    }

    @DeleteMapping("/v1/auth/employee/username/{username}")
    public ResponseEntity<?> deleteEmployeeByUsername(@PathVariable("username") String username) {
        EmployeeService.Response<Void> response = employeeService.deleteEmployeeByUsername(username);
        return createResponseEntity(response);
    }

    @DeleteMapping("/v1/auth/employee/email/{email}")
    public ResponseEntity<?> deleteEmployeeByEmail(@PathVariable("email") String email) {
        EmployeeService.Response<Void> response = employeeService.deleteEmployeeByEmail(email);
        return createResponseEntity(response);
    }

    private <T> ResponseEntity<?> createResponseEntity(EmployeeService.Response<T> response) {
        return switch (response.getStatus()) {
            case "Success" -> new ResponseEntity<>(response, HttpStatus.OK);
            case "Error" -> new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            case "Error404" -> new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            case "Error208" -> new ResponseEntity<>(response, HttpStatus.ALREADY_REPORTED);
            default ->
                    new ResponseEntity<>("Unknown status" + response.getMessage() + " /// " + response.getData(), HttpStatus.INTERNAL_SERVER_ERROR);
        };
    }
}
