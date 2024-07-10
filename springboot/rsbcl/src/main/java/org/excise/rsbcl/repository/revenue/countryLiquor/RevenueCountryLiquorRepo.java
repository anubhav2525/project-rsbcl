package org.excise.rsbcl.repository.revenue.countryLiquor;

import org.bson.types.ObjectId;
import org.excise.rsbcl.model.revenue.countryLiquor.RevenueCountryLiquor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RevenueCountryLiquorRepo extends MongoRepository<RevenueCountryLiquor, ObjectId> {
}
