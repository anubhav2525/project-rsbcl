package org.excise.rsbcl.repository.revenue.countryLiquor;

import org.bson.types.ObjectId;
import org.excise.rsbcl.model.revenue.countryLiquor.RevenueCountryLiquor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RevenueCountryLiquorRepo extends MongoRepository<RevenueCountryLiquor, ObjectId> {
    List<RevenueCountryLiquor> findByYear(int year);

    List<RevenueCountryLiquor> findByYearAndDistrict(int year,String district);

    List<RevenueCountryLiquor> findByYearAndDistrictAndMonth(int year, String district, String month);;
}
