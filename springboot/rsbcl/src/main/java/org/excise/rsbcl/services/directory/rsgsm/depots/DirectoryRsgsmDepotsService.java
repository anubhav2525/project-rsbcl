package org.excise.rsbcl.services.directory.rsgsm.depots;

import org.excise.rsbcl.model.directory.rsgsm.depots.DirectoryRsgsmDepots;
import org.excise.rsbcl.repository.directory.rsgsm.depots.DirectoryRsgsmDepotsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectoryRsgsmDepotsService {
    @Autowired
    private DirectoryRsgsmDepotsRepo directoryRsgsmDepotsRepo;

    public List<DirectoryRsgsmDepots> getAll(){
        return directoryRsgsmDepotsRepo.findAll();
    }
}
