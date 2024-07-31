package org.excise.rsbcl.repository.about.rsgsm.imes;

import org.bson.types.ObjectId;
import org.excise.rsbcl.model.about.rsgsm.imes.AboutRsgsmImes;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AboutRsgsmImesRepo extends MongoRepository<AboutRsgsmImes, ObjectId> {
}
