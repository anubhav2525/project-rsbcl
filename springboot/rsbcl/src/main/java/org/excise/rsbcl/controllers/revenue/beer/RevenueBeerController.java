package org.excise.rsbcl.controllers.revenue.beer;

import org.excise.rsbcl.model.revenue.beer.RevenueBeer;
import org.excise.rsbcl.services.revenue.beer.RevenueBeerService;
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
public class RevenueBeerController {
    @Autowired
    private RevenueBeerService revenueBeerService;

    @GetMapping("beer")
    public ResponseEntity<List<RevenueBeer>> getAll() {
        List<RevenueBeer> revenueBeers = revenueBeerService.getAll();
        if (revenueBeers.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(revenueBeers, HttpStatus.OK);
    }

    @GetMapping("beer/{year}")
    public ResponseEntity<List<RevenueBeer>> getRevenueBeerByYear(@PathVariable int year) {
        List<RevenueBeer> revenueBeers = revenueBeerService.getRevenueBeerByYear(year);
        if (revenueBeers.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(revenueBeers, HttpStatus.OK);
    }
}
