package org.excise.rsbcl.controllers.revenue.rml;

import org.excise.rsbcl.model.revenue.rml.RevenueRml;
import org.excise.rsbcl.services.revenue.rml.RevenueRmlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/revenue/")
public class RevenueRmlController {

    @Autowired
    private RevenueRmlService revenueRmlService;

    @GetMapping("rml")
    public ResponseEntity<List<RevenueRml>> getAll() {
        List<RevenueRml> revenueRmls = revenueRmlService.getAll();
        if (revenueRmls.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(revenueRmls, HttpStatus.OK);
    }

    @GetMapping("rml/{year}")
    public ResponseEntity<List<RevenueRml>> getRevenueRmlByYear(@PathVariable int year) {
        List<RevenueRml> revenueRmls = revenueRmlService.getRevenueRmlByYear(year);
        if (revenueRmls.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(revenueRmls, HttpStatus.OK);
    }
}
