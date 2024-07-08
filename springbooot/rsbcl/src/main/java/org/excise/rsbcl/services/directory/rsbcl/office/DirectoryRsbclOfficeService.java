package org.excise.rsbcl.services.directory.rsbcl.office;

import org.excise.rsbcl.model.directory.rsbcl.office.DirectoryRsbclOffice;
import org.excise.rsbcl.repository.directory.rsbcl.office.DirectoryRsbclOfficeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectoryRsbclOfficeService {
    @Autowired
    private DirectoryRsbclOfficeRepo directoryRsbclOfficeRepo;

    public List<DirectoryRsbclOffice> getAll() {
        return directoryRsbclOfficeRepo.findAll();
    }
}
