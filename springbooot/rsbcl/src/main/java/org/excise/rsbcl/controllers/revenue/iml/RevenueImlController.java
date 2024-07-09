package org.excise.rsbcl.controllers.revenue.iml;

import org.excise.rsbcl.model.revenue.iml.RevenueIml;
import org.excise.rsbcl.services.revenue.iml.RevenueImlService;
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
public class RevenueImlController {
    @Autowired
    private RevenueImlService revenueImlService;

    @GetMapping("iml")
    public ResponseEntity<List<RevenueIml>> getAll() {
        List<RevenueIml> revenueImls = revenueImlService.getAll();
        if (revenueImls.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(revenueImls, HttpStatus.OK);
    }

    @GetMapping("iml/{year}")
    public ResponseEntity<List<RevenueIml>> getRevenueImlByYear(@PathVariable int year) {
        List<RevenueIml> revenueImls = revenueImlService.getRevenueImlByYear(year);
        if (revenueImls.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(revenueImls, HttpStatus.OK);
    }
}
