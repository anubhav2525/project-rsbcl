package org.excise.rsbcl.repository.serviceProviders;

import org.bson.types.ObjectId;
import org.excise.rsbcl.model.serviceProviders.ServiceProviders;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceProvidersRepo extends MongoRepository<ServiceProviders, ObjectId> {
}
