package org.excise.rsbcl.services.sales.iml;

import org.excise.rsbcl.model.sales.iml.SalesIml;
import org.excise.rsbcl.repository.sales.iml.SalesImlRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesImlService {
    @Autowired
    private final SalesImlRepo salesImlRepo;

    public SalesImlService(SalesImlRepo salesImlRepo) {
        this.salesImlRepo = salesImlRepo;
    }

    public List<SalesIml> getAll() {
        return salesImlRepo.findAll();
    }

    public List<SalesIml> getSalesImlByYear(int year) {
        List<SalesIml> salesImls = salesImlRepo.findAll();
        return salesImls.stream().filter(salesIml -> salesIml.getYear() == year).toList();
    }

    public List<SalesIml> getSalesBeerByYearAndCategory(int year, String category) {
        return salesImlRepo.findByYearAndCategory(year, category);
    }
}
