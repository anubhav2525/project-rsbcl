package org.excise.rsbcl.controllers.directory.rsgsm.depots;

import org.excise.rsbcl.model.directory.rsgsm.depots.DirectoryRsgsmDepots;
import org.excise.rsbcl.services.directory.rsgsm.depots.DirectoryRsgsmDepotsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/directory-rsgsm-depots")
public class DirectoryRsgsmDepotsController {
    @Autowired
    private DirectoryRsgsmDepotsService directoryRsgsmDepotsService;

    @GetMapping
    public List<DirectoryRsgsmDepots> getAll(){
        return  directoryRsgsmDepotsService.getAll();
    }
}
