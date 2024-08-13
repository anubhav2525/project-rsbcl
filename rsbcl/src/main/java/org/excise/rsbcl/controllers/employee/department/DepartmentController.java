package org.excise.rsbcl.controllers.employee.department;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Valid;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.bson.types.ObjectId;
import org.excise.rsbcl.model.employee.department.Department;
import org.excise.rsbcl.services.employee.department.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class DepartmentController {
    @Autowired
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/v1/public/departments")
    public ResponseEntity<?> getAllDepartments() {
        DepartmentService.Response<List<Department>> response = departmentService.getAllDepartments();
        return createResponseEntity(response);
    }

    @GetMapping("/v1/auth/department/id/{id}")
    public ResponseEntity<?> getDepartmentById(@PathVariable("id") ObjectId id) {
        DepartmentService.Response<Department> response = departmentService.getDepartmentById(id);
        return createResponseEntity(response);
    }

    @GetMapping("/v1/auth/department/name/{departmentName}")
    public ResponseEntity<?> getDepartmentByDepartmentName(@PathVariable("departmentName") String departmentName) {
        DepartmentService.Response<Department> response = departmentService.getDepartmentByDepartmentName(departmentName);
        return createResponseEntity(response);
    }

    @PostMapping("/v1/auth/department")
    public ResponseEntity<?> saveDepartment(@Valid @RequestBody Department department, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }
        DepartmentService.Response<Department> response = departmentService.saveDepartment(department);
        return createResponseEntity(response);
    }

    @PostMapping("/v1/auth/department/save-entries")
    public ResponseEntity<?> saveDepartmentList(@Valid @RequestBody List<Department> departmentList, BindingResult bindingResult) {
        List<ObjectError> allErrors = new ArrayList<>(bindingResult.getAllErrors());

        // Manually validate each department in the list
        for (int i = 0; i < departmentList.size(); i++) {
            Department department = departmentList.get(i);
            BindingResult departmentBindingResult = new BeanPropertyBindingResult(department, "departmentList[" + i + "]");
            Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
            Set<ConstraintViolation<Department>> violations = validator.validate(department);
            for (ConstraintViolation<Department> violation : violations) {
                allErrors.add(new ObjectError("departmentList[" + i + "]." + violation.getPropertyPath(), violation.getMessage()));
            }
        }

        if (!allErrors.isEmpty()) {
            return ResponseEntity.badRequest().body(allErrors);
        }

        DepartmentService.Response<List<Department>> response = departmentService.saveDepartments(departmentList);
        return createResponseEntity(response);
    }

    @PutMapping("id/{id}")
    public ResponseEntity<?> updateDepartmentById(@PathVariable("id") ObjectId id, @RequestBody Department department) {
        DepartmentService.Response<Department> response = departmentService.updateDeparmentById(id, department);
        return createResponseEntity(response);
    }

    @PutMapping("name/{departmentName}")
    public ResponseEntity<?> updateDepartmentByDepartmentName(@PathVariable("departmentName") String departmentName, @RequestBody Department department) {
        DepartmentService.Response<Department> response = departmentService.updateDepartmentByDepartmentName(departmentName, department);
        return createResponseEntity(response);
    }

    @DeleteMapping("id/{id}")
    public ResponseEntity<?> deleteDepartmentById(@PathVariable("id") ObjectId id) {
        DepartmentService.Response<Void> response = departmentService.deleteDepartmentById(id);
        return createResponseEntity(response);
    }

    @DeleteMapping("name/{departmentName}")
    public ResponseEntity<?> deleteDepartmentByDepartmentName(@PathVariable("departmentName") String departmentName) {
        DepartmentService.Response<Void> response = departmentService.deleteByDepartmentName(departmentName);
        return createResponseEntity(response);
    }

    private <T> ResponseEntity<?> createResponseEntity(DepartmentService.Response<T> response) {
        return switch (response.getStatus()) {
            case "Success" -> new ResponseEntity<>(response, HttpStatus.OK);
            case "Error" -> new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            case "Error404" -> new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            default -> new ResponseEntity<>("Unknown status", HttpStatus.INTERNAL_SERVER_ERROR);
        };
    }
}
