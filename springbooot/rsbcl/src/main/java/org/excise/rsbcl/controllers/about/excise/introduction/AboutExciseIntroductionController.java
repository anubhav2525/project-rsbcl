package org.excise.rsbcl.controllers.about.excise.introduction;

import org.excise.rsbcl.model.about.excise.introduction.AboutExciseIntroduction;
import org.excise.rsbcl.services.about.excise.introduction.AboutExciseIntroductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/about-excise-introduction")
public class AboutExciseIntroductionController {
    @Autowired
    private AboutExciseIntroductionService aboutExciseIntroductionService;

    @GetMapping
    public List<AboutExciseIntroduction> getAll() {
        return aboutExciseIntroductionService.getAll();
    }
}
