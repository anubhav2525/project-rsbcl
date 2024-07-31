package org.excise.rsbcl.repository.revenue.rml;

import org.bson.types.ObjectId;
import org.excise.rsbcl.model.revenue.rml.RevenueRml;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RevenueRmlRepo extends MongoRepository<RevenueRml, ObjectId> {
    List<RevenueRml> findByYear(int year);

    List<RevenueRml> findByYearAndDistrict(int year, String district);

    List<RevenueRml> findByYearAndDistrictAndMonth(int year, String district, String month);
}
