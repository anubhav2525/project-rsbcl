package org.excise.rsbcl.services.about.rsgsm.turnOverProfit;

import org.excise.rsbcl.model.about.rsgsm.turnOverProfit.AboutRsgsmTurnOverProfit;
import org.excise.rsbcl.repository.about.rsgsm.turnOverProfit.AboutRsgsmTurnOverProfitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AboutRsgsmTurnOverProfitService {
    @Autowired
    private AboutRsgsmTurnOverProfitRepo aboutRsgsmTurnOverProfitRepo;

    public List<AboutRsgsmTurnOverProfit> getAll() {
        return aboutRsgsmTurnOverProfitRepo.findAll();
    }
}
