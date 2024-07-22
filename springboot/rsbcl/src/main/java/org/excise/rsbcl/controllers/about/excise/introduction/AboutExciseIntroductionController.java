package org.excise.rsbcl.controllers.about.excise.introduction;

import org.excise.rsbcl.model.about.excise.introduction.AboutExciseIntroduction;
import org.excise.rsbcl.services.about.excise.introduction.AboutExciseIntroductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/about-excise/")
public class AboutExciseIntroductionController {
    @Autowired
    private final AboutExciseIntroductionService aboutExciseIntroductionService;

    public AboutExciseIntroductionController(AboutExciseIntroductionService aboutExciseIntroductionService) {
        this.aboutExciseIntroductionService = aboutExciseIntroductionService;
    }

    @GetMapping("introduction")
    public ResponseEntity<List<AboutExciseIntroduction>> getAll() {
        List<AboutExciseIntroduction> aboutExciseIntroductions = aboutExciseIntroductionService.getAll();
        if (aboutExciseIntroductions.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(aboutExciseIntroductions, HttpStatus.OK);
    }
}
