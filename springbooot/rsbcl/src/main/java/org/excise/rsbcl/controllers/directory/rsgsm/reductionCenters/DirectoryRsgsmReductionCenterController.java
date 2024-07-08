package org.excise.rsbcl.controllers.directory.rsgsm.reductionCenters;

import org.excise.rsbcl.model.directory.rsgsm.reductionCenters.DirectoryRsgsmReductionCenter;
import org.excise.rsbcl.services.directory.rsgsm.reductionCenters.DirectoryRsgsmReductionCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/directory-rsgsm-reductionCenters")
public class DirectoryRsgsmReductionCenterController {
    @Autowired
    private DirectoryRsgsmReductionCenterService directoryRsgsmReductionCenterService;

    @GetMapping
    public List<DirectoryRsgsmReductionCenter> getAll() {
        return directoryRsgsmReductionCenterService.getAll();
    }
}
