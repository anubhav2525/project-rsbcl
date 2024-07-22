package org.excise.rsbcl.controllers.directory.rsgsm.depots;

import org.excise.rsbcl.model.directory.rsgsm.depots.DirectoryRsgsmDepots;
import org.excise.rsbcl.services.directory.rsgsm.depots.DirectoryRsgsmDepotsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/directory-rsgsm-depots")
public class DirectoryRsgsmDepotsController {
    @Autowired
    private final DirectoryRsgsmDepotsService directoryRsgsmDepotsService;

    public DirectoryRsgsmDepotsController(DirectoryRsgsmDepotsService directoryRsgsmDepotsService) {
        this.directoryRsgsmDepotsService = directoryRsgsmDepotsService;
    }

    @GetMapping
    public ResponseEntity<List<DirectoryRsgsmDepots>> getAll() {
        List<DirectoryRsgsmDepots> directoryRsgsmDepots = directoryRsgsmDepotsService.getAll();
        if (directoryRsgsmDepots.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(directoryRsgsmDepots, HttpStatus.OK);
    }
}
