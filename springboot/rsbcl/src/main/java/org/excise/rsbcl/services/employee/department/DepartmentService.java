package org.excise.rsbcl.services.employee.department;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.excise.rsbcl.model.employee.department.Department;
import org.excise.rsbcl.repository.employee.department.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    @Autowired
    private final DepartmentRepo departmentRepo;

    public DepartmentService(DepartmentRepo departmentRepo) {
        this.departmentRepo = departmentRepo;
    }

    // role verification in employee
    public boolean departmentExists(String departmentName) {
        return departmentRepo.findByDepartmentName(departmentName).isPresent();
    }

    public Response<List<Department>> getAllDepartments() {
        try {
            List<Department> departments = departmentRepo.findAll();
            if (departments.isEmpty()) return new Response<>("Error404", "Departments not found", null);
            return new Response<>("Success", "Departments are found", departments);
        } catch (Exception e) {
            return new Response<>("Error", e.getMessage(), null);
        }
    }

    public Response<Department> getDepartmentById(ObjectId id) {
        try {
            Department department = departmentRepo.findById(id).orElse(null);
            if (department != null) return new Response<>("Success", "Department found", department);
            return new Response<>("Error404", "Department is not found", null);
        } catch (Exception e) {
            return new Response<>("Error", e.getMessage(), null);
        }
    }

    public Response<Department> getDepartmentByDepartmentName(String departmentName) {
        try {
            Department department = departmentRepo.findByDepartmentName(departmentName).orElse(null);
            if (department != null) return new Response<>("Success", "Department found", department);
            return new Response<>("Error404", "Department is not found", null);
        } catch (Exception e) {
            return new Response<>("Error", e.getMessage(), null);
        }
    }

    public Response<Department> saveDepartment(Department department) {
        try {
            Department oldDepartment = departmentRepo.findByDepartmentName(department.getDepartmentName()).orElse(null);
            if (oldDepartment != null) {
                return new Response<>("Error", "Department already exists", null);
            } else {
                department.setLastUpdate(LocalDateTime.now());
                Department savedDepartment = departmentRepo.save(department);
                return new Response<>("Success", "Department saved successfully", savedDepartment);
            }
        } catch (Exception e) {
            return new Response<>("Error", e.getMessage(), null);
        }
    }

    public Response<List<Department>> saveDepartments(List<Department> departments) {
        try {
            List<Department> departments1 = new ArrayList<>();
            // updating time
            for (Department department : departments) {
                department.setLastUpdate(LocalDateTime.now());
                departments1.add(department);
            }
            List<Department> savedDepartments = departmentRepo.saveAll(departments1);
            return new Response<>("Success", "Departments saved successfully", savedDepartments);
        } catch (Exception e) {
            return new Response<>("Error", e.getMessage(), null);
        }
    }

    public Response<Department> updateDeparmentById(ObjectId id, Department department) {
        try {
            Department oldDepartment = departmentRepo.findById(id).orElse(null);
            if (oldDepartment != null) {
                oldDepartment.setLastUpdate(LocalDateTime.now());
                oldDepartment.setDepartmentSize(department.getDepartmentSize());
                oldDepartment.setStatus(department.isStatus());
                oldDepartment.setDepartmentName(department.getDepartmentName());
                oldDepartment.setDescription(department.getDescription());
                Department savedDepartment = departmentRepo.save(oldDepartment);
                return new Response<>("Success", "Department updated successfully", savedDepartment);
            } else {
                return new Response<>("Error404", "Department not found", null);
            }
        } catch (Exception e) {
            return new Response<>("Error", e.getMessage(), null);
        }
    }

    public Response<Department> updateDepartmentByDepartmentName(String departmentName, Department department) {
        try {
            Department oldDepartment = departmentRepo.findByDepartmentName(departmentName).orElse(null);
            if (oldDepartment != null) {
                oldDepartment.setLastUpdate(LocalDateTime.now());
                oldDepartment.setDepartmentSize(department.getDepartmentSize());
                oldDepartment.setStatus(department.isStatus());
                oldDepartment.setDepartmentName(department.getDepartmentName());
                oldDepartment.setDescription(department.getDescription());
                oldDepartment.setDepartmentSize(department.getDepartmentSize());
                Department savedDepartment = departmentRepo.save(oldDepartment);
                return new Response<>("Success", "Department updated successfully", savedDepartment);
            } else {
                return new Response<>("Error404", "Department not found", null);
            }
        } catch (Exception e) {
            return new Response<>("Error", e.getMessage(), null);
        }
    }

    public Response<Void> deleteDepartmentById(ObjectId id) {
        try {
            Optional<Department> oldDepartment = departmentRepo.findById(id);
            if (oldDepartment.isPresent()) {
                departmentRepo.deleteById(id);
                return new Response<>("Success", "Department deleted successfully", null);
            } else {
                return new Response<>("Error404", "Department not found", null);
            }
        } catch (Exception e) {
            return new Response<>("Error", e.getMessage(), null);
        }
    }

    public Response<Void> deleteByDepartmentName(String departmentName) {
        try {
            Optional<Department> oldDepartment = departmentRepo.findByDepartmentName(departmentName);
            if (oldDepartment.isPresent()) {
                departmentRepo.deleteByDepartmentName(departmentName);
                return new Response<>("Success", "Department deleted successfully", null);
            } else {
                return new Response<>("Error404", "Department not found", null);
            }
        } catch (Exception e) {
            return new Response<>("Error", e.getMessage(), null);
        }
    }

    // Response static class
    @Setter
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response<T> {
        private String status;
        private String message;
        private T data;
    }
}
