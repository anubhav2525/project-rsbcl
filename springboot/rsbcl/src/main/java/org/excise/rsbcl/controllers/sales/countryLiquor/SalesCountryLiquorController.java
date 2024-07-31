package org.excise.rsbcl.controllers.sales.countryLiquor;

import org.excise.rsbcl.model.sales.countryLiquor.SalesCountryLiquor;
import org.excise.rsbcl.services.sales.countryLiquor.SalesCountryLiquorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class SalesCountryLiquorController {
    @Autowired
    private final SalesCountryLiquorService salesCountryLiquorService;

    public SalesCountryLiquorController(SalesCountryLiquorService salesCountryLiquorService) {
        this.salesCountryLiquorService = salesCountryLiquorService;
    }

    @GetMapping("v1/sales/countryLiquors")
    public ResponseEntity<List<SalesCountryLiquor>> getAll() {
        List<SalesCountryLiquor> salesCountryLiquors = salesCountryLiquorService.getAll();
        if (salesCountryLiquors.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(salesCountryLiquors, HttpStatus.OK);
    }

    @GetMapping("v1/sales/countryLiquor-by-year")
    public ResponseEntity<List<SalesCountryLiquor>> getSalesCountryLiquorByYear(@RequestParam int year) {
        List<SalesCountryLiquor> salesCountryLiquors = salesCountryLiquorService.getSalesCountryLiquorByYear(year);
        if (salesCountryLiquors.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(salesCountryLiquors, HttpStatus.OK);
    }

    @GetMapping("v1/sales/countryLiquor")
    public ResponseEntity<List<SalesCountryLiquor>> getSalesCountryLiquorYearAndCategory(@RequestParam int year, String category) {
        List<SalesCountryLiquor> salesCountryLiquors = salesCountryLiquorService.getSalesBeerByYearAndCategory(year, category);
        if (salesCountryLiquors.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(salesCountryLiquors, HttpStatus.OK);
    }
}
