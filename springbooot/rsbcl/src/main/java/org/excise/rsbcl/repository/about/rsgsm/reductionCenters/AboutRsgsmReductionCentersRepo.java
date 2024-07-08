package org.excise.rsbcl.repository.about.rsgsm.reductionCenters;

import org.bson.types.ObjectId;
import org.excise.rsbcl.model.about.rsgsm.reductionCenters.AboutRsgsmReductionCenters;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AboutRsgsmReductionCentersRepo extends MongoRepository<AboutRsgsmReductionCenters, ObjectId> {
}
