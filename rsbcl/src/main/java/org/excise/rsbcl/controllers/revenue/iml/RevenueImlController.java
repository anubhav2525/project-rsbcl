package org.excise.rsbcl.controllers.revenue.iml;

import org.excise.rsbcl.model.revenue.iml.RevenueIml;
import org.excise.rsbcl.services.revenue.iml.RevenueImlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class RevenueImlController {
    @Autowired
    private final RevenueImlService revenueImlService;

    public RevenueImlController(RevenueImlService revenueImlService) {
        this.revenueImlService = revenueImlService;
    }

    @GetMapping("v1/revenue/imls")
    public ResponseEntity<List<RevenueIml>> getAll() {
        List<RevenueIml> revenueImls = revenueImlService.getAll();
        if (revenueImls.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(revenueImls, HttpStatus.OK);
    }

    @GetMapping("v1/revenue/iml")
    public ResponseEntity<List<RevenueIml>> getRevenueImlByYear(@RequestParam int year) {
        List<RevenueIml> revenueImls = revenueImlService.getRevenueImlByYear(year);
        if (revenueImls.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(revenueImls, HttpStatus.OK);
    }

    @GetMapping("v1/revenue/iml-by-year-and-range")
    public ResponseEntity<List<RevenueIml>> getRevenueBeerByYearAndRange(@RequestParam int year) {
        List<RevenueIml> revenueImls = revenueImlService.getRevenueBeerByYearAndRange(year);
        if (revenueImls.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(revenueImls, HttpStatus.OK);
    }
}
