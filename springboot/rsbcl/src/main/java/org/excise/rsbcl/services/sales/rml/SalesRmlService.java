package org.excise.rsbcl.services.sales.rml;

import org.excise.rsbcl.model.sales.rml.SalesRml;
import org.excise.rsbcl.repository.sales.rml.SalesRmlRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesRmlService {
    @Autowired
    private final SalesRmlRepo salesRmlRepo;

    public SalesRmlService(SalesRmlRepo salesRmlRepo) {
        this.salesRmlRepo = salesRmlRepo;
    }

    public List<SalesRml> getAll() {
        return salesRmlRepo.findAll();
    }

    public List<SalesRml> getSalesRmlByYear(int year) {
        List<SalesRml> salesRmls = salesRmlRepo.findAll();
        return salesRmls.stream().filter(salesRml -> salesRml.getYear() == year).toList();
    }

    public List<SalesRml> getSalesBeerByYearAndCategory(int year, String category) {
        return salesRmlRepo.findByYearAndCategory(year, category);
    }
}
