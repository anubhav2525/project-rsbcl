package org.excise.rsbcl.repository.about.excise.introduction;

import org.bson.types.ObjectId;
import org.excise.rsbcl.model.about.excise.introduction.AboutExciseIntroduction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AboutExciseIntroductionRepo extends MongoRepository<AboutExciseIntroduction, ObjectId> {
}
