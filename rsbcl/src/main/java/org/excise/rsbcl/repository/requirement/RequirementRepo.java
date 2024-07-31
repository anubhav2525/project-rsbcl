package org.excise.rsbcl.repository.requirement;

import org.bson.types.ObjectId;
import org.excise.rsbcl.model.requirement.Requirement;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequirementRepo extends MongoRepository<Requirement, ObjectId> {
}
