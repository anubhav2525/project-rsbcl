package org.excise.rsbcl.services.about.rsgsm.liquors;

import org.excise.rsbcl.model.about.rsgsm.liquors.AboutRsgsmLiquors;
import org.excise.rsbcl.repository.about.rsgsm.liquors.AboutRsgsmLiquorsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AboutRsgsmLiquorsService {
    @Autowired
    private AboutRsgsmLiquorsRepo aboutRsgsmLiquorsRepo;

    public List<AboutRsgsmLiquors> getAll() {
        return aboutRsgsmLiquorsRepo.findAll();
    }
}
