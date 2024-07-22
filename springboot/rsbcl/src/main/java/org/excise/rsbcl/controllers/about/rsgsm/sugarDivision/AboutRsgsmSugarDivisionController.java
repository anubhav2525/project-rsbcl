package org.excise.rsbcl.controllers.about.rsgsm.sugarDivision;

import org.excise.rsbcl.model.about.rsgsm.sugarDivision.AboutRsgsmSugarDivision;
import org.excise.rsbcl.services.about.rsgsm.sugarDivision.AboutRsgsmSugarDivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/about-rsgsm/")
public class AboutRsgsmSugarDivisionController {
    @Autowired
    private final AboutRsgsmSugarDivisionService aboutRsgsmSugarDivisionService;

    public AboutRsgsmSugarDivisionController(AboutRsgsmSugarDivisionService aboutRsgsmSugarDivisionService) {
        this.aboutRsgsmSugarDivisionService = aboutRsgsmSugarDivisionService;
    }

    @GetMapping("sugar-cane-division")
    public ResponseEntity<List<AboutRsgsmSugarDivision>> getAll() {
        List<AboutRsgsmSugarDivision> aboutRsgsmSugarDivisions = aboutRsgsmSugarDivisionService.getAll();
        if (aboutRsgsmSugarDivisions.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(aboutRsgsmSugarDivisions, HttpStatus.OK);
    }
}
