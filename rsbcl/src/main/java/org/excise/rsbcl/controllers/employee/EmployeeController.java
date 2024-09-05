package org.excise.rsbcl.controllers.employee;

import jakarta.validation.Valid;
import org.bson.types.ObjectId;
import org.excise.rsbcl.model.employee.Employee;
import org.excise.rsbcl.services.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

//    @GetMapping("/v1/auth/employees")
//    public ResponseEntity<?> getAllEmployees() {
//        EmployeeService.Response<List<Employee>> responses = employeeService.getAllEmployees();
//        return createResponseEntity(responses);
//    }

    @GetMapping("/v1/auth/employee/id/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable("id") ObjectId id) {
        EmployeeService.Response<Employee> response = employeeService.getEmployeeById(id);
        return createResponseEntity(response);
    }

    @GetMapping("/v1/auth/employees")
    public ResponseEntity<?> getEmployees(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        EmployeeService.Response<Page<Employee>> response = employeeService.getEmployees(page, size);
        return createResponseEntity(response);
    }

    @PostMapping("/v1/auth/employee")
    public ResponseEntity<?> saveEmployee( @RequestBody Employee employee){
        EmployeeService.Response<?> response = employeeService.saveEmployee(employee);
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
