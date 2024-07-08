package org.excise.rsbcl.services.sales.countryLiquor;

import org.excise.rsbcl.model.sales.countryLiquor.SalesCountryLiquor;
import org.excise.rsbcl.repository.sales.countryLiquor.SalesCountryLiquorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SalesCountryLiquorService {
    @Autowired
    private SalesCountryLiquorRepo salesCountryLiquorRepo;

    public List<SalesCountryLiquor> getAll() {
        return salesCountryLiquorRepo.findAll();
    }

    public List<SalesCountryLiquor> getSalesCountryLiquorByYear(int year) {
        List<SalesCountryLiquor> salesCountryLiquors = salesCountryLiquorRepo.findAll();
        return salesCountryLiquors.stream()
                .filter(salesCountryLiquor -> salesCountryLiquor.getYear() == year)
                .collect(Collectors.toList());
    }
}
