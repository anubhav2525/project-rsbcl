package org.excise.rsbcl.controllers.about.rsgsm.liquors;

import org.excise.rsbcl.model.about.rsgsm.liquors.AboutRsgsmLiquors;
import org.excise.rsbcl.services.about.rsgsm.liquors.AboutRsgsmLiquorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/about-rsgsm/")
public class AboutRsgsmLiquorsController {
    @Autowired
    private final AboutRsgsmLiquorsService aboutRsgsmLiquorsService;

    public AboutRsgsmLiquorsController(AboutRsgsmLiquorsService aboutRsgsmLiquorsService) {
        this.aboutRsgsmLiquorsService = aboutRsgsmLiquorsService;
    }

    @GetMapping("liquors")
    public ResponseEntity<List<AboutRsgsmLiquors>> getAll() {
        List<AboutRsgsmLiquors> aboutRsgsmLiquors = aboutRsgsmLiquorsService.getAll();
        if (aboutRsgsmLiquors.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(aboutRsgsmLiquors, HttpStatus.OK);
    }
}
