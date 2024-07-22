package org.excise.rsbcl.controllers.sales.beer;

import org.excise.rsbcl.model.sales.beer.SalesBeer;
import org.excise.rsbcl.services.sales.beer.SalesBeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sales/")
public class SalesBeerController {
    @Autowired
    private final SalesBeerService salesBeerService;

    public SalesBeerController(SalesBeerService salesBeerService) {
        this.salesBeerService = salesBeerService;
    }

    @GetMapping("beers")
    public ResponseEntity<List<SalesBeer>> getAll() {
        List<SalesBeer> salesBeers = salesBeerService.getAll();
        if (salesBeers.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(salesBeers, HttpStatus.OK);
    }

    @GetMapping("beer-by-year")
    public ResponseEntity<List<SalesBeer>> getSalesBeerByYear(@RequestParam int year) {
        List<SalesBeer> salesBeers = salesBeerService.getSalesBeerByYear(year);
        if (salesBeers.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(salesBeers, HttpStatus.OK);
    }

    @GetMapping("beer")
    public ResponseEntity<List<SalesBeer>> getSalesByYearAndcategory(@RequestParam int year, String category) {
        List<SalesBeer> salesBeerList = salesBeerService.getSalesBeerByYearAndCategory(year, category);
        if (salesBeerList.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(salesBeerList, HttpStatus.OK);
    }
}
