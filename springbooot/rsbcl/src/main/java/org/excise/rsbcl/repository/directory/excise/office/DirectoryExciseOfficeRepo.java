package org.excise.rsbcl.repository.directory.excise.office;

import org.bson.types.ObjectId;
import org.excise.rsbcl.model.directory.excise.office.DirectoryExciseOffice;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectoryExciseOfficeRepo extends MongoRepository<DirectoryExciseOffice, ObjectId> {
}
