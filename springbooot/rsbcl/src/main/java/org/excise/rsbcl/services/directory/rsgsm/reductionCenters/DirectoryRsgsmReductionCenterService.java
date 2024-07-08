package org.excise.rsbcl.services.directory.rsgsm.reductionCenters;

import org.excise.rsbcl.model.directory.rsgsm.reductionCenters.DirectoryRsgsmReductionCenter;
import org.excise.rsbcl.repository.directory.rsgsm.reductionCenters.DirectoryRsgsmReductionCenterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectoryRsgsmReductionCenterService {
    @Autowired
    private DirectoryRsgsmReductionCenterRepo directoryRsgsmReductionCenterRepo;

    public List<DirectoryRsgsmReductionCenter> getAll(){
        return directoryRsgsmReductionCenterRepo.findAll();
    }
}
