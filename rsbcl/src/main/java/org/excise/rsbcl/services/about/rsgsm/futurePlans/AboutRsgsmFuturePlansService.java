package org.excise.rsbcl.services.about.rsgsm.futurePlans;

import org.excise.rsbcl.model.about.rsgsm.futurePlans.AboutRsgsmFuturePlans;
import org.excise.rsbcl.repository.about.rsgsm.futurePlans.AboutRsgsmFuturePlansRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AboutRsgsmFuturePlansService {
    @Autowired
    private AboutRsgsmFuturePlansRepo aboutRsgsmFuturePlansRepo;

    public List<AboutRsgsmFuturePlans> getAll(){
        return aboutRsgsmFuturePlansRepo.findAll();
    }
}
