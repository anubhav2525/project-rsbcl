package org.excise.rsbcl.controllers.about.rsbcl.introduction;

import org.excise.rsbcl.model.about.rsbcl.introduction.AboutRsbclIntroduction;
import org.excise.rsbcl.services.about.rsbcl.introduction.AboutRsbclIntroductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/about-rsbcl/")
public class AboutRsbclIntroductionController {
    @Autowired
    private final AboutRsbclIntroductionService aboutRsbclIntroductionService;

    public AboutRsbclIntroductionController(AboutRsbclIntroductionService aboutRsbclIntroductionService) {
        this.aboutRsbclIntroductionService = aboutRsbclIntroductionService;
    }

    @GetMapping("introduction")
    public ResponseEntity<List<AboutRsbclIntroduction>> getAll() {
        List<AboutRsbclIntroduction> aboutRsbclIntroductions = aboutRsbclIntroductionService.getAll();
        if (aboutRsbclIntroductions.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(aboutRsbclIntroductions, HttpStatus.OK);
    }
}
