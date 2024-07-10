package org.excise.rsbcl.repository.sales.countryLiquor;

import org.bson.types.ObjectId;
import org.excise.rsbcl.model.sales.countryLiquor.SalesCountryLiquor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesCountryLiquorRepo extends MongoRepository<SalesCountryLiquor, ObjectId> {
}
