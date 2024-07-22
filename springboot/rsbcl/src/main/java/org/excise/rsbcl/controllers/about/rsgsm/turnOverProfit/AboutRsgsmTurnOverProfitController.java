package org.excise.rsbcl.controllers.about.rsgsm.turnOverProfit;

import org.excise.rsbcl.model.about.rsgsm.turnOverProfit.AboutRsgsmTurnOverProfit;
import org.excise.rsbcl.services.about.rsgsm.turnOverProfit.AboutRsgsmTurnOverProfitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/about-rsgsm/")
public class AboutRsgsmTurnOverProfitController {
    @Autowired
    private final AboutRsgsmTurnOverProfitService aboutRsgsmTurnOverProfitService;

    public AboutRsgsmTurnOverProfitController(AboutRsgsmTurnOverProfitService aboutRsgsmTurnOverProfitService) {
        this.aboutRsgsmTurnOverProfitService = aboutRsgsmTurnOverProfitService;
    }

    @GetMapping("turnover-profit")
    public ResponseEntity<List<AboutRsgsmTurnOverProfit>> getAll() {
        List<AboutRsgsmTurnOverProfit> aboutRsgsmTurnOverProfits = aboutRsgsmTurnOverProfitService.getAll();
        if (aboutRsgsmTurnOverProfits.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(aboutRsgsmTurnOverProfits, HttpStatus.OK);
    }
}
