package org.excise.rsbcl.controllers.about.rsbcl.directors;

import org.excise.rsbcl.model.about.rsbcl.directors.AboutRsbclDirector;
import org.excise.rsbcl.services.about.rsbcl.directors.AboutRsbclDirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/about-rsbcl-directors")
public class AboutRsbclDirectorController {
    @Autowired
    private AboutRsbclDirectorService aboutRsbclDirectorService;

    @GetMapping
    public List<AboutRsbclDirector> getAll(){
        return aboutRsbclDirectorService.getAll();
    }
}
