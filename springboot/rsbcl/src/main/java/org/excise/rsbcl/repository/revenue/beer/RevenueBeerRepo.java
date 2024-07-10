package org.excise.rsbcl.repository.revenue.beer;

import org.bson.types.ObjectId;
import org.excise.rsbcl.model.revenue.beer.RevenueBeer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RevenueBeerRepo extends MongoRepository<RevenueBeer, ObjectId> {
}
