package org.excise.rsbcl.controllers.revenue.countryLiquor;

import org.excise.rsbcl.model.revenue.beer.RevenueBeer;
import org.excise.rsbcl.model.revenue.countryLiquor.RevenueCountryLiquor;
import org.excise.rsbcl.services.revenue.countryLiquor.RevenueCountryLiquorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class RevenueCountryLiquorController {
    @Autowired
    private final RevenueCountryLiquorService revenueCountryLiquorService;

    public RevenueCountryLiquorController(RevenueCountryLiquorService revenueCountryLiquorService) {
        this.revenueCountryLiquorService = revenueCountryLiquorService;
    }

    @GetMapping("v1/revenue/countryLiquors")
    public ResponseEntity<List<RevenueCountryLiquor>> getAll() {
        List<RevenueCountryLiquor> revenueCountryLiquors = revenueCountryLiquorService.getAll();
        if (revenueCountryLiquors.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(revenueCountryLiquors, HttpStatus.OK);
    }

    @GetMapping("v1/revenue/countryLiquor")
    public ResponseEntity<List<RevenueCountryLiquor>> getRevenueCountryLiquorByYear(@RequestParam int year) {
        List<RevenueCountryLiquor> revenueCountryLiquors = revenueCountryLiquorService.getRevenueCountryLiquorByYear(year);
        if (revenueCountryLiquors.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(revenueCountryLiquors, HttpStatus.OK);
    }

    @GetMapping("v1/revenue/countryLiquor-by-year-and-range")
    public ResponseEntity<List<RevenueCountryLiquor>> getRevenueBeerByYearAndRange(@RequestParam int year) {
        List<RevenueCountryLiquor> revenueCountryLiquors = revenueCountryLiquorService.getRevenueBeerByYearAndRange(year);
        if (revenueCountryLiquors.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(revenueCountryLiquors, HttpStatus.OK);
    }
}