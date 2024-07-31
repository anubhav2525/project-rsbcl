package org.excise.rsbcl.repository.employee.UsersRepo;

import org.bson.types.ObjectId;
import org.excise.rsbcl.model.employee.users.UserForget;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserForgetRepo extends MongoRepository<UserForget, ObjectId> {
    Optional<UserForget> findByUsername(String username);
}
