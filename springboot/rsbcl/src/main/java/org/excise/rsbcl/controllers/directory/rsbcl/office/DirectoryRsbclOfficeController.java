package org.excise.rsbcl.controllers.directory.rsbcl.office;

import org.excise.rsbcl.model.directory.rsbcl.office.DirectoryRsbclOffice;
import org.excise.rsbcl.services.directory.rsbcl.office.DirectoryRsbclOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/directory-rsbcl-office")
public class DirectoryRsbclOfficeController {
    @Autowired
    private final DirectoryRsbclOfficeService directoryRsbclOfficeService;

    public DirectoryRsbclOfficeController(DirectoryRsbclOfficeService directoryRsbclOfficeService) {
        this.directoryRsbclOfficeService = directoryRsbclOfficeService;
    }

    @GetMapping
    public ResponseEntity<List<DirectoryRsbclOffice>> getAll() {
        List<DirectoryRsbclOffice> directoryRsbclOffices = directoryRsbclOfficeService.getAll();
        if (directoryRsbclOffices.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(directoryRsbclOffices, HttpStatus.OK);
    }
}
