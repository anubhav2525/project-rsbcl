package org.excise.rsbcl.services.revenue.rml;

import org.excise.rsbcl.model.revenue.beer.RevenueBeer;
import org.excise.rsbcl.model.revenue.rml.RevenueRml;
import org.excise.rsbcl.repository.revenue.rml.RevenueRmlRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RevenueRmlService {
    @Autowired
    private RevenueRmlRepo revenueRmlRepo;

    public List<RevenueRml> getAll() {
        return revenueRmlRepo.findAll();
    }

    public List<RevenueRml> getRevenueRmlByYear(int year) {
        List<RevenueRml> revenueRmls = revenueRmlRepo.findAll();
        return revenueRmls.stream().filter(revenueRml -> revenueRml.getYear() == year).toList();
    }

    public List<RevenueRml> getRevenueBeerByYearAndDistrict(int year, String district, String month) {
        return revenueRmlRepo.findByYearAndDistrictAndMonth(year, district, month);
    }

    public List<RevenueRml> getRevenueBeerByYearAndRange(int year) {
        List<RevenueRml> revenueRmls = revenueRmlRepo.findByYear(year);
        return revenueRmls.subList(0, 10);
    }
}
