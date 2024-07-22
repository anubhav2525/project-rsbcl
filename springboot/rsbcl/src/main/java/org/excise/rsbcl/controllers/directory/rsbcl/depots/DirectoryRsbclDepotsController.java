package org.excise.rsbcl.controllers.directory.rsbcl.depots;

import org.excise.rsbcl.model.directory.rsbcl.depots.DirectoryRsbclDepots;
import org.excise.rsbcl.services.directory.rsbcl.depots.DirectoryRsbclDepotsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/directory-rsbcl-depots")
public class DirectoryRsbclDepotsController {
    @Autowired
    private final DirectoryRsbclDepotsService directoryRsbclDepotsService;

    public DirectoryRsbclDepotsController(DirectoryRsbclDepotsService directoryRsbclDepotsService) {
        this.directoryRsbclDepotsService = directoryRsbclDepotsService;
    }

    @GetMapping
    public ResponseEntity<List<DirectoryRsbclDepots>> getAll() {
        List<DirectoryRsbclDepots> directoryRsbclDepots = directoryRsbclDepotsService.getAll();
        if (directoryRsbclDepots.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(directoryRsbclDepots, HttpStatus.OK);
    }
}
