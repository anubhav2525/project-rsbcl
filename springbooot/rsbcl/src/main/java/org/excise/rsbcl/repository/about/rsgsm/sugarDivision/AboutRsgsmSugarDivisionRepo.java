package org.excise.rsbcl.repository.about.rsgsm.sugarDivision;

import org.bson.types.ObjectId;
import org.excise.rsbcl.model.about.rsgsm.sugarDivision.AboutRsgsmSugarDivision;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AboutRsgsmSugarDivisionRepo extends MongoRepository<AboutRsgsmSugarDivision, ObjectId> {
}
