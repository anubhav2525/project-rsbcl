package org.excise.rsbcl.repository.employee.department;

import org.bson.types.ObjectId;
import org.excise.rsbcl.model.employee.department.Department;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartmentRepo extends MongoRepository<Department, ObjectId> {
    Optional<Department> findByDepartmentName(String departmentName);

    void deleteByDepartmentName(String departmentName);
}
