package org.excise.rsbcl.controllers.sales.iml;

import org.excise.rsbcl.model.sales.iml.SalesIml;
import org.excise.rsbcl.services.sales.iml.SalesImlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sales/")
public class SalesImlController {
    @Autowired
    private final SalesImlService salesImlService;

    public SalesImlController(SalesImlService salesImlService) {
        this.salesImlService = salesImlService;
    }

    @GetMapping("imls")
    public ResponseEntity<List<SalesIml>> getAll() {
        List<SalesIml> salesImls = salesImlService.getAll();
        if (salesImls.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(salesImls, HttpStatus.OK);
    }

    @GetMapping("iml-by-year")
    public ResponseEntity<List<SalesIml>> getSalesImlByYear(@RequestParam int year) {
        List<SalesIml> salesImls = salesImlService.getSalesImlByYear(year);
        if (salesImls.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(salesImls, HttpStatus.OK);
    }

    @GetMapping("iml")
    public ResponseEntity<List<SalesIml>> getSalesImlByYearAndCategory(@RequestParam int year, String category) {
        List<SalesIml> salesImls = salesImlService.getSalesBeerByYearAndCategory(year, category);
        if (salesImls.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(salesImls, HttpStatus.OK);
    }
}
