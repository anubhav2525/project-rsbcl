package org.excise.rsbcl.repository.directory.rsbcl.depots;

import org.bson.types.ObjectId;
import org.excise.rsbcl.model.directory.rsbcl.depots.DirectoryRsbclDepots;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DirectoryRsbclDepotsRepo extends MongoRepository<DirectoryRsbclDepots, ObjectId> {
    Optional<DirectoryRsbclDepots> findByEmail(String email);
}
