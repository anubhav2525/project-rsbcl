package org.excise.rsbcl.repository.revenue.iml;

import org.bson.types.ObjectId;
import org.excise.rsbcl.model.revenue.iml.RevenueIml;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RevenueImlRepo extends MongoRepository<RevenueIml, ObjectId> {
    List<RevenueIml> findByYear(int year);

    List<RevenueIml> findByYearAndDistrict(int year,String district);

    List<RevenueIml> findByYearAndDistrictAndMonth(int year, String district, String month);
}
