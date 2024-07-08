package org.excise.rsbcl.controllers.about.rsbcl.introduction;

import org.excise.rsbcl.model.about.rsbcl.introduction.AboutRsbclIntroduction;
import org.excise.rsbcl.services.about.rsbcl.introduction.AboutRsbclIntroductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/about-rsbcl-introduction")
public class AboutRsbclIntroductionController {
    @Autowired
    private AboutRsbclIntroductionService aboutRsbclIntroductionService;

    @GetMapping
    public List<AboutRsbclIntroduction> getAll(){
        return aboutRsbclIntroductionService.getAll();
    }
}
