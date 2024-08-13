package org.excise.rsbcl.repository.mobileApp;

import org.bson.types.ObjectId;
import org.excise.rsbcl.model.mobileApp.MobileApp;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MobileAppRepo extends MongoRepository<MobileApp, ObjectId> {
    Optional<MobileApp> findByAppName(String appName);

}
