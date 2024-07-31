package org.excise.rsbcl.services.about.rsgsm.financialStatus;

import org.excise.rsbcl.model.about.rsgsm.financialStatus.AboutRsgsmFinancialStatus;
import org.excise.rsbcl.repository.about.rsgsm.financialStatus.AboutRsgsmFinancialStatusRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AboutRsgsmFinancialStatusService {
    @Autowired
    private AboutRsgsmFinancialStatusRepo aboutRsgsmFinancialStatusRepo;

  public List<AboutRsgsmFinancialStatus> getAll(){
      return aboutRsgsmFinancialStatusRepo.findAll();
  }
}
