package org.excise.rsbcl.controllers.directory.rsgsm.reductionCenters;

import org.excise.rsbcl.model.directory.rsgsm.reductionCenters.DirectoryRsgsmReductionCenter;
import org.excise.rsbcl.services.directory.rsgsm.reductionCenters.DirectoryRsgsmReductionCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/directory-rsgsm-reductionCenters")
public class DirectoryRsgsmReductionCenterController {
    @Autowired
    private final DirectoryRsgsmReductionCenterService directoryRsgsmReductionCenterService;

    public DirectoryRsgsmReductionCenterController(DirectoryRsgsmReductionCenterService directoryRsgsmReductionCenterService) {
        this.directoryRsgsmReductionCenterService = directoryRsgsmReductionCenterService;
    }

    @GetMapping
    public ResponseEntity<List<DirectoryRsgsmReductionCenter>> getAll() {
        List<DirectoryRsgsmReductionCenter> directoryRsgsmReductionCenters = directoryRsgsmReductionCenterService.getAll();
        if ((directoryRsgsmReductionCenters.isEmpty())) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(directoryRsgsmReductionCenters, HttpStatus.OK);

    }
}
