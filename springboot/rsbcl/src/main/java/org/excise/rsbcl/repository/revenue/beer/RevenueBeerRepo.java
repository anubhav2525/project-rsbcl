package org.excise.rsbcl.repository.revenue.beer;

import org.bson.types.ObjectId;
import org.excise.rsbcl.model.revenue.beer.RevenueBeer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RevenueBeerRepo extends MongoRepository<RevenueBeer, ObjectId> {
    List<RevenueBeer> findByYear(int year);

    List<RevenueBeer> findByYearAndDistrict(int year, String district);

    List<RevenueBeer> findByYearAndDistrictAndMonth(int year, String district, String month);
}
