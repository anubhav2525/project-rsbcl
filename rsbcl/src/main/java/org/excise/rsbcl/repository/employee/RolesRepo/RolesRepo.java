package org.excise.rsbcl.repository.employee.RolesRepo;

import org.bson.types.ObjectId;
import org.excise.rsbcl.model.employee.roles.Roles;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolesRepo extends MongoRepository<Roles, ObjectId> {
    Optional<Roles> findByRole(String role);

    void deleteByRole(String role);
}
