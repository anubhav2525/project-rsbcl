package org.excise.rsbcl.controllers.sales.rml;

import org.excise.rsbcl.model.sales.rml.SalesRml;
import org.excise.rsbcl.services.sales.rml.SalesRmlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sales/")
public class SalesRmlController {
    @Autowired
    private final SalesRmlService salesRmlService;

    public SalesRmlController(SalesRmlService salesRmlService) {
        this.salesRmlService = salesRmlService;
    }

    @GetMapping("rmls")
    public ResponseEntity<List<SalesRml>> getAll() {
        List<SalesRml> salesRmls = salesRmlService.getAll();
        if (salesRmls.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(salesRmls, HttpStatus.OK);
    }

    @GetMapping("rml-by-year")
    public ResponseEntity<List<SalesRml>> getSalesRmlByYear(@RequestParam int year) {
        List<SalesRml> salesRmls = salesRmlService.getSalesRmlByYear(year);
        if (salesRmls.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(salesRmls, HttpStatus.OK);
    }

    @GetMapping("rml")
    public ResponseEntity<List<SalesRml>> getSalesRmlByYearAndCategory(@RequestParam int year, String category) {
        List<SalesRml> salesRmls = salesRmlService.getSalesBeerByYearAndCategory(year, category);
        if (salesRmls.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(salesRmls, HttpStatus.OK);
    }
}
