package org.excise.rsbcl.controllers.directory.excise.office;

import org.excise.rsbcl.model.directory.excise.office.DirectoryExciseOffice;
import org.excise.rsbcl.services.directory.excise.office.DirectoryExciseOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/directory-excise-office")
public class DirectoryExciseOfficeController {
    @Autowired
    private DirectoryExciseOfficeService directoryExciseOfficeService;

    @GetMapping
    public List<DirectoryExciseOffice> getAll() {
        return directoryExciseOfficeService.getAll();
    }
}
