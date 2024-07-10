package org.excise.rsbcl.repository.about.rsgsm.financialStatus;

import org.bson.types.ObjectId;
import org.excise.rsbcl.model.about.rsgsm.financialStatus.AboutRsgsmFinancialStatus;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AboutRsgsmFinancialStatusRepo extends MongoRepository<AboutRsgsmFinancialStatus, ObjectId> {
}
