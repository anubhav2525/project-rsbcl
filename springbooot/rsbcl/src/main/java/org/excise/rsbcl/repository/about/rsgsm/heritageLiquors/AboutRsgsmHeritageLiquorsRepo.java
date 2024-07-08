package org.excise.rsbcl.repository.about.rsgsm.heritageLiquors;

import org.bson.types.ObjectId;
import org.excise.rsbcl.model.about.rsgsm.heritageLiquors.AboutRsgsmHeritageLiquors;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AboutRsgsmHeritageLiquorsRepo extends MongoRepository<AboutRsgsmHeritageLiquors, ObjectId> {
}
