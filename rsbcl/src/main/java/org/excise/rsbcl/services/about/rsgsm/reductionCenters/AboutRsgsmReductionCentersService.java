package org.excise.rsbcl.services.about.rsgsm.reductionCenters;

import org.excise.rsbcl.model.about.rsgsm.reductionCenters.AboutRsgsmReductionCenters;
import org.excise.rsbcl.repository.about.rsgsm.reductionCenters.AboutRsgsmReductionCentersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AboutRsgsmReductionCentersService {
    @Autowired
    private AboutRsgsmReductionCentersRepo aboutRsgsmReductionCentersRepo;

    public List<AboutRsgsmReductionCenters> getAll() {
        return aboutRsgsmReductionCentersRepo.findAll();
    }
}
