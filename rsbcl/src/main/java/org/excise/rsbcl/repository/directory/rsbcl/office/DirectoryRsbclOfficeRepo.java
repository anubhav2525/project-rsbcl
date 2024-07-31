package org.excise.rsbcl.repository.directory.rsbcl.office;

import org.bson.types.ObjectId;
import org.excise.rsbcl.model.directory.rsbcl.office.DirectoryRsbclOffice;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DirectoryRsbclOfficeRepo extends MongoRepository<DirectoryRsbclOffice, ObjectId> {
    Optional<DirectoryRsbclOffice> findByEmail(String email);
}
