package org.excise.rsbcl.repository.employee;

import org.bson.types.ObjectId;
import org.excise.rsbcl.model.employee.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepo extends MongoRepository<Employee, ObjectId> {
    Optional<Employee> findByEmail(String email);

}
