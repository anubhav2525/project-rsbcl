package org.excise.rsbcl.repository.about.rsgsm.futurePlans;

import org.bson.types.ObjectId;
import org.excise.rsbcl.model.about.rsgsm.futurePlans.AboutRsgsmFuturePlans;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AboutRsgsmFuturePlansRepo extends MongoRepository<AboutRsgsmFuturePlans, ObjectId> {
}
