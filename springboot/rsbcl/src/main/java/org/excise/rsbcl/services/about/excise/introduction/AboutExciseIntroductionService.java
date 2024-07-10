package org.excise.rsbcl.services.about.excise.introduction;

import org.excise.rsbcl.model.about.excise.introduction.AboutExciseIntroduction;
import org.excise.rsbcl.repository.about.excise.introduction.AboutExciseIntroductionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AboutExciseIntroductionService {
    @Autowired
    private AboutExciseIntroductionRepo aboutExciseIntroductionRepo;

    public List<AboutExciseIntroduction> getAll() {
        return aboutExciseIntroductionRepo.findAll();
    }
}
