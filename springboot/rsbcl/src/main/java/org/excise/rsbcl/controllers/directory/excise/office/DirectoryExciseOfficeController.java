package org.excise.rsbcl.controllers.directory.excise.office;

import org.excise.rsbcl.model.directory.excise.office.DirectoryExciseOffice;
import org.excise.rsbcl.services.directory.excise.office.DirectoryExciseOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/directory-excise-office")
public class DirectoryExciseOfficeController {
    @Autowired
    private final DirectoryExciseOfficeService directoryExciseOfficeService;

    public DirectoryExciseOfficeController(DirectoryExciseOfficeService directoryExciseOfficeService) {
        this.directoryExciseOfficeService = directoryExciseOfficeService;
    }

    @GetMapping
    public ResponseEntity<List<DirectoryExciseOffice>> getAll() {
        List<DirectoryExciseOffice> directoryExciseOffices = directoryExciseOfficeService.getAll();
        if (directoryExciseOffices.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(directoryExciseOffices, HttpStatus.OK);
    }
}
