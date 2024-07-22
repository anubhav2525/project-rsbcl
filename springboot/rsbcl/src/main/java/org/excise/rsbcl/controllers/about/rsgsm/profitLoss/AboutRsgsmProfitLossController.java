package org.excise.rsbcl.controllers.about.rsgsm.profitLoss;

import org.excise.rsbcl.model.about.rsgsm.profitLoss.AboutRsgsmProfitLoss;
import org.excise.rsbcl.services.about.rsgsm.profitLoss.AboutRsgsmProfitLossService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/about-rsgsm/")
public class AboutRsgsmProfitLossController {
    @Autowired
    private final AboutRsgsmProfitLossService aboutRsgsmProfitLossService;

    public AboutRsgsmProfitLossController(AboutRsgsmProfitLossService aboutRsgsmProfitLossService) {
        this.aboutRsgsmProfitLossService = aboutRsgsmProfitLossService;
    }

    @GetMapping("profit-loss")
    public ResponseEntity<List<AboutRsgsmProfitLoss>> getAll() {
        List<AboutRsgsmProfitLoss> aboutRsgsmProfitLosses = aboutRsgsmProfitLossService.getAll();
        if (aboutRsgsmProfitLosses.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(aboutRsgsmProfitLosses, HttpStatus.OK);
    }
}
