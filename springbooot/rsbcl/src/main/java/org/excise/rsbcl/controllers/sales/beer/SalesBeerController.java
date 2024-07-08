package org.excise.rsbcl.controllers.sales.beer;

import org.excise.rsbcl.model.sales.beer.SalesBeer;
import org.excise.rsbcl.services.sales.beer.SalesBeerService;
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
public class SalesBeerController {
    @Autowired
    private SalesBeerService salesBeerService;

    @GetMapping("beer")
    public List<SalesBeer> getAll() {
        return salesBeerService.getAll();
    }

    @GetMapping("beer/{year}")
    public ResponseEntity<List<SalesBeer>> getSalesBeerByYear(@PathVariable int year) {
        List<SalesBeer> salesBeers = salesBeerService.getSalesBeerByYear(year);
        if (salesBeers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(salesBeers, HttpStatus.OK);
    }
}
