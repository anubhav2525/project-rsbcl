package org.excise.rsbcl.services.about.rsgsm.sugarDivision;

import org.excise.rsbcl.model.about.rsgsm.sugarDivision.AboutRsgsmSugarDivision;
import org.excise.rsbcl.repository.about.rsgsm.sugarDivision.AboutRsgsmSugarDivisionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AboutRsgsmSugarDivisionService {
    @Autowired
    private AboutRsgsmSugarDivisionRepo aboutRsgsmSugarDivisionRepo;

    public List<AboutRsgsmSugarDivision> getAll() {
        return aboutRsgsmSugarDivisionRepo.findAll();
    }
}
