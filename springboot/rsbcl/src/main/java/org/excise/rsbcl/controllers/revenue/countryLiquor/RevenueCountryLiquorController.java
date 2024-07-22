package org.excise.rsbcl.controllers.revenue.countryLiquor;

import org.excise.rsbcl.model.revenue.countryLiquor.RevenueCountryLiquor;
import org.excise.rsbcl.services.revenue.countryLiquor.RevenueCountryLiquorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/revenue/")
public class RevenueCountryLiquorController {
    @Autowired
    private final RevenueCountryLiquorService revenueCountryLiquorService;

    public RevenueCountryLiquorController(RevenueCountryLiquorService revenueCountryLiquorService) {
        this.revenueCountryLiquorService = revenueCountryLiquorService;
    }

    @GetMapping("countryLiquors")
    public ResponseEntity<List<RevenueCountryLiquor>> getAll() {
        List<RevenueCountryLiquor> revenueCountryLiquors = revenueCountryLiquorService.getAll();
        if (revenueCountryLiquors.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(revenueCountryLiquors, HttpStatus.OK);
    }

    @GetMapping("countryLiquor")
    public ResponseEntity<List<RevenueCountryLiquor>> getRevenueCountryLiquorByYear(@RequestParam int year) {
        List<RevenueCountryLiquor> revenueCountryLiquors = revenueCountryLiquorService.getRevenueCountryLiquorByYear(year);
        if (revenueCountryLiquors.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(revenueCountryLiquors, HttpStatus.OK);
    }
}