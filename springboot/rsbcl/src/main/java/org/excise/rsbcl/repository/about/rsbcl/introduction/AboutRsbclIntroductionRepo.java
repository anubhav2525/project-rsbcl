package org.excise.rsbcl.repository.about.rsbcl.introduction;

import org.bson.types.ObjectId;
import org.excise.rsbcl.model.about.rsbcl.introduction.AboutRsbclIntroduction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AboutRsbclIntroductionRepo extends MongoRepository<AboutRsbclIntroduction, ObjectId> {
}
