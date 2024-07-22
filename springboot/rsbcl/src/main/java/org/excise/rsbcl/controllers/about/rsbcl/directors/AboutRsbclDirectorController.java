package org.excise.rsbcl.controllers.about.rsbcl.directors;

import org.excise.rsbcl.model.about.rsbcl.directors.AboutRsbclDirector;
import org.excise.rsbcl.services.about.rsbcl.directors.AboutRsbclDirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/about-rsbcl/")
public class AboutRsbclDirectorController {
    @Autowired
    private final AboutRsbclDirectorService aboutRsbclDirectorService;

    public AboutRsbclDirectorController(AboutRsbclDirectorService aboutRsbclDirectorService) {
        this.aboutRsbclDirectorService = aboutRsbclDirectorService;
    }

    @GetMapping("directors")
    public ResponseEntity<List<AboutRsbclDirector>> getAll() {
        List<AboutRsbclDirector> aboutRsbclDirectors = aboutRsbclDirectorService.getAll();
        if (aboutRsbclDirectors.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(aboutRsbclDirectors, HttpStatus.OK);
    }
}
