package org.excise.rsbcl.controllers.about.rsgsm.reductionCenters;

import org.excise.rsbcl.model.about.rsgsm.reductionCenters.AboutRsgsmReductionCenters;
import org.excise.rsbcl.services.about.rsgsm.reductionCenters.AboutRsgsmReductionCentersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/about-rsgsm/")
public class AboutRsgsmReductionCentersController {
    @Autowired
    private final AboutRsgsmReductionCentersService aboutRsgsmReductionCentersService;

    public AboutRsgsmReductionCentersController(AboutRsgsmReductionCentersService aboutRsgsmReductionCentersService) {
        this.aboutRsgsmReductionCentersService = aboutRsgsmReductionCentersService;
    }

    @GetMapping("reduction-centers")
    public ResponseEntity<List<AboutRsgsmReductionCenters>> getAll() {
        List<AboutRsgsmReductionCenters> aboutRsgsmReductionCenters = aboutRsgsmReductionCentersService.getAll();
        if (aboutRsgsmReductionCenters.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(aboutRsgsmReductionCenters, HttpStatus.OK);
    }
}
