package org.excise.rsbcl.controllers.about.rsgsm.heritageLiquors;

import org.excise.rsbcl.model.about.rsgsm.heritageLiquors.AboutRsgsmHeritageLiquors;
import org.excise.rsbcl.services.about.rsgsm.heritageLiquors.AboutRsgsmHeritageLiquorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/about-rsgsm/")
public class AboutRsgsmHeritageLiquorsController {
    @Autowired
    private final AboutRsgsmHeritageLiquorsService aboutRsgsmHeritageLiquorsService;

    public AboutRsgsmHeritageLiquorsController(AboutRsgsmHeritageLiquorsService aboutRsgsmHeritageLiquorsService) {
        this.aboutRsgsmHeritageLiquorsService = aboutRsgsmHeritageLiquorsService;
    }

    @GetMapping("heritage-liquors")
    public ResponseEntity<List<AboutRsgsmHeritageLiquors>> getAll() {
        List<AboutRsgsmHeritageLiquors> aboutRsgsmHeritageLiquors = aboutRsgsmHeritageLiquorsService.getAll();
        if (aboutRsgsmHeritageLiquors.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(aboutRsgsmHeritageLiquors, HttpStatus.OK);
    }
}
