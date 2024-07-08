package org.excise.rsbcl.repository.about.rsgsm.profitLoss;

import org.bson.types.ObjectId;
import org.excise.rsbcl.model.about.rsgsm.profitLoss.AboutRsgsmProfitLoss;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AboutRsgsmProfitLossRepo extends MongoRepository<AboutRsgsmProfitLoss, ObjectId> {
}
