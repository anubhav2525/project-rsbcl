package org.excise.rsbcl.services.sales.beer;

import org.excise.rsbcl.model.sales.beer.SalesBeer;
import org.excise.rsbcl.repository.sales.beer.SalesBeerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesBeerService {
    @Autowired
    private SalesBeerRepo salesBeerRepo;

    public List<SalesBeer> getAll() {
        return salesBeerRepo.findAll();
    }

    public List<SalesBeer> getSalesBeerByYear(int year) {
        List<SalesBeer> salesBeers = salesBeerRepo.findAll();
        return salesBeers.stream().filter(salesBeer -> salesBeer.getYear() == year).toList();
    }

    public List<SalesBeer> getSalesBeerByYearAndCategory(int year, String category) {
        return salesBeerRepo.findByYearAndCategory(year, category);

    }
}
