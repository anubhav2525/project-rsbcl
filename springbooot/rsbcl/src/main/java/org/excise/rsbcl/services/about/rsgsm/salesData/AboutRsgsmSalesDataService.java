package org.excise.rsbcl.services.about.rsgsm.salesData;

import org.excise.rsbcl.model.about.rsgsm.salesData.AboutRsgsmSalesData;
import org.excise.rsbcl.repository.about.rsgsm.salesData.AboutRsgsmSalesDataRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AboutRsgsmSalesDataService {
    @Autowired
    private AboutRsgsmSalesDataRepo aboutRsgsmSalesDataRepo;

    public List<AboutRsgsmSalesData> getAll() {
        return aboutRsgsmSalesDataRepo.findAll();
    }
}
