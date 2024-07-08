package org.excise.rsbcl.repository.about.rsgsm.turnOverProfit;

import org.bson.types.ObjectId;
import org.excise.rsbcl.model.about.rsgsm.turnOverProfit.AboutRsgsmTurnOverProfit;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AboutRsgsmTurnOverProfitRepo extends MongoRepository<AboutRsgsmTurnOverProfit, ObjectId> {
}
