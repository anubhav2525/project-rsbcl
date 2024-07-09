package org.excise.rsbcl.services.about.rsgsm.profitLoss;

import org.excise.rsbcl.model.about.rsgsm.profitLoss.AboutRsgsmProfitLoss;
import org.excise.rsbcl.repository.about.rsgsm.profitLoss.AboutRsgsmProfitLossRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AboutRsgsmProfitLossService {
    @Autowired
    private AboutRsgsmProfitLossRepo aboutRsgsmProfitLossRepo;

    public List<AboutRsgsmProfitLoss> getAll() {
        return aboutRsgsmProfitLossRepo.findAll();
    }
}
