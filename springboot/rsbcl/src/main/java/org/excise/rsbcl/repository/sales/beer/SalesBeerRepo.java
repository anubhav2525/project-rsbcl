package org.excise.rsbcl.repository.sales.beer;

import org.bson.types.ObjectId;
import org.excise.rsbcl.model.sales.beer.SalesBeer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalesBeerRepo extends MongoRepository<SalesBeer, ObjectId> {
    List<SalesBeer> findByYearAndCategory(int year, String category);
}
