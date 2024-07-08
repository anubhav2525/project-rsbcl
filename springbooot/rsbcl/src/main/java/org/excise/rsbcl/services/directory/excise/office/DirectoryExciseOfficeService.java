package org.excise.rsbcl.services.directory.excise.office;

import org.excise.rsbcl.model.directory.excise.office.DirectoryExciseOffice;
import org.excise.rsbcl.repository.directory.excise.office.DirectoryExciseOfficeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectoryExciseOfficeService {
    @Autowired
    private DirectoryExciseOfficeRepo directoryExciseOfficeRepo;

    public List<DirectoryExciseOffice> getAll() {
        return directoryExciseOfficeRepo.findAll();
    }
}
