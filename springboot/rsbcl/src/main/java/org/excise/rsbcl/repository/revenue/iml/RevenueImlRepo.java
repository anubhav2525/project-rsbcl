package org.excise.rsbcl.repository.revenue.iml;

import org.bson.types.ObjectId;
import org.excise.rsbcl.model.revenue.iml.RevenueIml;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RevenueImlRepo extends MongoRepository<RevenueIml, ObjectId> {
}
