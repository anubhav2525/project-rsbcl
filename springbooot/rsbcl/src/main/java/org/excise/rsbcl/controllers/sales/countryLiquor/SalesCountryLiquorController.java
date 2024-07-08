package org.excise.rsbcl.controllers.sales.countryLiquor;

import org.excise.rsbcl.model.sales.countryLiquor.SalesCountryLiquor;
import org.excise.rsbcl.services.sales.countryLiquor.SalesCountryLiquorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sales/")
public class SalesCountryLiquorController {
    @Autowired
    private SalesCountryLiquorService salesCountryLiquorService;

    @GetMapping("countryLiquor")
    public List<SalesCountryLiquor> getAll() {
        return salesCountryLiquorService.getAll();
    }

    @GetMapping("countryLiquor/{year}")
    public List<SalesCountryLiquor> getSalesCountryLiquorByYear(@PathVariable int year) {
        return salesCountryLiquorService.getSalesCountryLiquorByYear(year);
    }
}
