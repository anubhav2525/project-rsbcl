package org.excise.rsbcl.controllers.about.rsgsm.futurePlans;

import org.excise.rsbcl.model.about.rsgsm.futurePlans.AboutRsgsmFuturePlans;
import org.excise.rsbcl.services.about.rsgsm.futurePlans.AboutRsgsmFuturePlansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/about-rsgsm/")
public class AboutRsgsmFuturePlansController {
    @Autowired
    private final AboutRsgsmFuturePlansService aboutRsgsmFuturePlansService;

    public AboutRsgsmFuturePlansController(AboutRsgsmFuturePlansService aboutRsgsmFuturePlansService) {
        this.aboutRsgsmFuturePlansService = aboutRsgsmFuturePlansService;
    }

    @GetMapping("future-plans")
    public ResponseEntity<List<AboutRsgsmFuturePlans>> getAll() {
        List<AboutRsgsmFuturePlans> aboutRsgsmFuturePlans = aboutRsgsmFuturePlansService.getAll();
        if (aboutRsgsmFuturePlans.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(aboutRsgsmFuturePlans, HttpStatus.OK);
    }
}
