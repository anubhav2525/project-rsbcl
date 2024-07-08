package org.excise.rsbcl.repository.sales.rml;

import org.bson.types.ObjectId;
import org.excise.rsbcl.model.sales.rml.SalesRml;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesRmlRepo extends MongoRepository<SalesRml, ObjectId> {
}
