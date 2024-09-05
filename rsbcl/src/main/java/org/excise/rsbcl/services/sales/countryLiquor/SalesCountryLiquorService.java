package org.excise.rsbcl.services.sales.countryLiquor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.excise.rsbcl.controllers.sales.beer.SalesBeerController;
import org.excise.rsbcl.model.sales.beer.SalesBeer;
import org.excise.rsbcl.model.sales.countryLiquor.SalesCountryLiquor;
import org.excise.rsbcl.repository.sales.countryLiquor.SalesCountryLiquorRepo;
import org.excise.rsbcl.services.sales.beer.SalesBeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SalesCountryLiquorService {
    @Autowired
    private final SalesCountryLiquorRepo salesCountryLiquorRepo;

    public SalesCountryLiquorService(SalesCountryLiquorRepo salesCountryLiquorRepo) {
        this.salesCountryLiquorRepo = salesCountryLiquorRepo;
    }

    public List<SalesCountryLiquor> getAll() {
        return salesCountryLiquorRepo.findAll();
    }

    public List<SalesCountryLiquor> getSalesCountryLiquorByYear(int year) {
        List<SalesCountryLiquor> salesCountryLiquors = salesCountryLiquorRepo.findAll();
        return salesCountryLiquors.stream()
                .filter(salesCountryLiquor -> salesCountryLiquor.getYear() == year)
                .collect(Collectors.toList());
    }

    public List<SalesCountryLiquor> getSalesBeerByYearAndCategory(int year, String category) {
        return salesCountryLiquorRepo.findByYearAndCategory(year, category);
    }

    public Response<?> saveSalesCLs(List<SalesCountryLiquor> salesCountryLiquors) {
        try {
            salesCountryLiquorRepo.saveAll(salesCountryLiquors);
            return new Response<>("Success", "saved", null);
        } catch (Exception e) {
            return new Response<>("Error", e.getMessage(), null);
        }
    }

    public Response<?> saveSalesCL(SalesCountryLiquor salesCountryLiquor) {
        try {
            salesCountryLiquorRepo.save(salesCountryLiquor);
            return new Response<>("Success", "saved", null);
        } catch (Exception e) {
            return new Response<>("Error", e.getMessage(), null);
        }
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response<T> {
        private String status;
        private String message;
        private T data;
    }
}
