package org.excise.rsbcl.repository.about.rsgsm.liquors;

import org.bson.types.ObjectId;
import org.excise.rsbcl.model.about.rsgsm.liquors.AboutRsgsmLiquors;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AboutRsgsmLiquorsRepo extends MongoRepository<AboutRsgsmLiquors, ObjectId> {
}
