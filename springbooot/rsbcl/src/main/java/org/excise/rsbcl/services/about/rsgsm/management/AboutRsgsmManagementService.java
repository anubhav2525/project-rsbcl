package org.excise.rsbcl.services.about.rsgsm.management;

import org.excise.rsbcl.model.about.rsgsm.management.AboutRsgsmManagement;
import org.excise.rsbcl.repository.about.rsgsm.management.AboutRsgsmManagementRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AboutRsgsmManagementService {
    @Autowired
    private AboutRsgsmManagementRepo aboutRsgsmManagementRepo;

    public List<AboutRsgsmManagement> getAll(){
        return aboutRsgsmManagementRepo.findAll();
    }
}
