package org.excise.rsbcl.controllers.revenue.rml;

import org.excise.rsbcl.model.revenue.rml.RevenueRml;
import org.excise.rsbcl.services.revenue.rml.RevenueRmlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/revenue/")
public class RevenueRmlController {

    @Autowired
    private final RevenueRmlService revenueRmlService;

    public RevenueRmlController(RevenueRmlService revenueRmlService) {
        this.revenueRmlService = revenueRmlService;
    }

    @GetMapping("rmls")
    public ResponseEntity<List<RevenueRml>> getAll() {
        List<RevenueRml> revenueRmls = revenueRmlService.getAll();
        if (revenueRmls.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(revenueRmls, HttpStatus.OK);
    }

    @GetMapping("rml")
    public ResponseEntity<List<RevenueRml>> getRevenueRmlByYear(@RequestParam int year) {
        List<RevenueRml> revenueRmls = revenueRmlService.getRevenueRmlByYear(year);
        if (revenueRmls.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(revenueRmls, HttpStatus.OK);
    }
}
