package org.excise.rsbcl.controllers.sales.countryLiquor;

import org.excise.rsbcl.model.sales.countryLiquor.SalesCountryLiquor;
import org.excise.rsbcl.services.sales.countryLiquor.SalesCountryLiquorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<SalesCountryLiquor>> getAll() {
        List<SalesCountryLiquor> salesCountryLiquors = salesCountryLiquorService.getAll();
        if (salesCountryLiquors.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(salesCountryLiquors, HttpStatus.OK);
    }

    @GetMapping("countryLiquor/{year}")
    public ResponseEntity<List<SalesCountryLiquor>> getSalesCountryLiquorByYear(@PathVariable int year) {
        List<SalesCountryLiquor> salesCountryLiquors = salesCountryLiquorService.getSalesCountryLiquorByYear(year);
        if (salesCountryLiquors.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(salesCountryLiquors, HttpStatus.OK);
    }
}
