package org.excise.rsbcl.repository.revenue.rml;

import org.bson.types.ObjectId;
import org.excise.rsbcl.model.revenue.rml.RevenueRml;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RevenueRmlRepo extends MongoRepository<RevenueRml, ObjectId> {
}
