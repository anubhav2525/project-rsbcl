package org.excise.rsbcl.controllers.directory.rsbcl.office;

import org.excise.rsbcl.model.directory.rsbcl.office.DirectoryRsbclOffice;
import org.excise.rsbcl.services.directory.rsbcl.office.DirectoryRsbclOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/directory-rsbcl-office")
public class DirectoryRsbclOfficeController {
    @Autowired
    private DirectoryRsbclOfficeService directoryRsbclOfficeService;

    @GetMapping
    public List<DirectoryRsbclOffice> getAll() {
        return directoryRsbclOfficeService.getAll();
    }
}
