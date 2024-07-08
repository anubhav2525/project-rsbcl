package org.excise.rsbcl.repository.about.rsgsm.management;

import org.bson.types.ObjectId;
import org.excise.rsbcl.model.about.rsgsm.management.AboutRsgsmManagement;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AboutRsgsmManagementRepo extends MongoRepository<AboutRsgsmManagement, ObjectId> {
}
