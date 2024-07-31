package org.excise.rsbcl.controllers.revenue.rml;

import org.excise.rsbcl.model.revenue.rml.RevenueRml;
import org.excise.rsbcl.services.revenue.rml.RevenueRmlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class RevenueRmlController {

    @Autowired
    private final RevenueRmlService revenueRmlService;

    public RevenueRmlController(RevenueRmlService revenueRmlService) {
        this.revenueRmlService = revenueRmlService;
    }

    @GetMapping("v1/revenue/rmls")
    public ResponseEntity<List<RevenueRml>> getAll() {
        List<RevenueRml> revenueRmls = revenueRmlService.getAll();
        if (revenueRmls.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(revenueRmls, HttpStatus.OK);
    }

    @GetMapping("v1/revenue/rml")
    public ResponseEntity<List<RevenueRml>> getRevenueRmlByYear(@RequestParam int year) {
        List<RevenueRml> revenueRmls = revenueRmlService.getRevenueRmlByYear(year);
        if (revenueRmls.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(revenueRmls, HttpStatus.OK);
    }

    @GetMapping("v1/revenue/rml-by-year-and-range")
    public ResponseEntity<List<RevenueRml>> getRevenueBeerByYearAndRange(@RequestParam int year) {
        List<RevenueRml> revenueRmls = revenueRmlService.getRevenueBeerByYearAndRange(year);
        if (revenueRmls.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(revenueRmls, HttpStatus.OK);
    }
}
