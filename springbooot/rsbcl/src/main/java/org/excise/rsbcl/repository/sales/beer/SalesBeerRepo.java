package org.excise.rsbcl.repository.sales.beer;

import org.bson.types.ObjectId;
import org.excise.rsbcl.model.sales.beer.SalesBeer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesBeerRepo extends MongoRepository<SalesBeer, ObjectId> {
}
