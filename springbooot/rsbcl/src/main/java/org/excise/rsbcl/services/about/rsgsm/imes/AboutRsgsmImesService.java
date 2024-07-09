package org.excise.rsbcl.services.about.rsgsm.imes;

import org.excise.rsbcl.model.about.rsgsm.imes.AboutRsgsmImes;
import org.excise.rsbcl.repository.about.rsgsm.imes.AboutRsgsmImesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AboutRsgsmImesService {
    @Autowired
    private AboutRsgsmImesRepo aboutRsgsmImesRepo;

    public List<AboutRsgsmImes> getAll() {
        return aboutRsgsmImesRepo.findAll();
    }
}
