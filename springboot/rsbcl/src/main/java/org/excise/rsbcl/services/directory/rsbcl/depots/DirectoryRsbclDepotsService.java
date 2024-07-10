package org.excise.rsbcl.services.directory.rsbcl.depots;

import org.excise.rsbcl.model.directory.rsbcl.depots.DirectoryRsbclDepots;
import org.excise.rsbcl.repository.directory.rsbcl.depots.DirectoryRsbclDepotsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectoryRsbclDepotsService {
    @Autowired
    private DirectoryRsbclDepotsRepo directoryRsbclDepotsRepo;

    public List<DirectoryRsbclDepots> getAll(){
        return directoryRsbclDepotsRepo.findAll();
    }
}
