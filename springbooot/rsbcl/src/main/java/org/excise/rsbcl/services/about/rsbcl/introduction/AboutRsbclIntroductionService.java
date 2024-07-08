package org.excise.rsbcl.services.about.rsbcl.introduction;

import org.excise.rsbcl.model.about.rsbcl.introduction.AboutRsbclIntroduction;
import org.excise.rsbcl.repository.about.rsbcl.introduction.AboutRsbclIntroductionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AboutRsbclIntroductionService {
    @Autowired
    private AboutRsbclIntroductionRepo aboutRsbclIntroductionRepo;

    public List<AboutRsbclIntroduction> getAll(){
        return aboutRsbclIntroductionRepo.findAll();
    }
}
