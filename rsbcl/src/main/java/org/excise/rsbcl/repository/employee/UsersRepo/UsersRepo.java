package org.excise.rsbcl.repository.employee.UsersRepo;

import org.bson.types.ObjectId;
import org.excise.rsbcl.model.employee.users.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepo extends MongoRepository<Users, ObjectId> {
    Optional<Users> findByUsername(String username);

    void deleteByUsername(String username);
}
