package org.excise.rsbcl.services.revenue.countryLiquor;

import org.excise.rsbcl.model.revenue.countryLiquor.RevenueCountryLiquor;
import org.excise.rsbcl.repository.revenue.countryLiquor.RevenueCountryLiquorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RevenueCountryLiquorService {
    @Autowired
    private RevenueCountryLiquorRepo revenueCountryLiquorRepo;

    public List<RevenueCountryLiquor> getAll() {
        return revenueCountryLiquorRepo.findAll();
    }

    public List<RevenueCountryLiquor> getRevenueCountryLiquorByYear(int year) {
        List<RevenueCountryLiquor> revenueCountryLiquors = revenueCountryLiquorRepo.findAll();
        return revenueCountryLiquors.stream().filter(revenueCountryLiquor -> revenueCountryLiquor.getYear() == year).toList();
    }

    public List<RevenueCountryLiquor> getRevenueBeerByYearAndDistrict(int year, String district, String month) {
        return revenueCountryLiquorRepo.findByYearAndDistrictAndMonth(year, district, month);
    }

    public List<RevenueCountryLiquor> getRevenueBeerByYearAndRange(int year) {
        List<RevenueCountryLiquor> revenueCountryLiquors = revenueCountryLiquorRepo.findByYear(year);
        return revenueCountryLiquors.subList(0, 10);
    }
}
