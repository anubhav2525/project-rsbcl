package org.excise.rsbcl.services.about.rsgsm.heritageLiquors;

import org.excise.rsbcl.model.about.rsgsm.heritageLiquors.AboutRsgsmHeritageLiquors;
import org.excise.rsbcl.repository.about.rsgsm.heritageLiquors.AboutRsgsmHeritageLiquorsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AboutRsgsmHeritageLiquorsService {
    @Autowired
    private AboutRsgsmHeritageLiquorsRepo aboutRsgsmHeritageLiquorsRepo;

    public List<AboutRsgsmHeritageLiquors> getAll() {
        return aboutRsgsmHeritageLiquorsRepo.findAll();
    }
}
