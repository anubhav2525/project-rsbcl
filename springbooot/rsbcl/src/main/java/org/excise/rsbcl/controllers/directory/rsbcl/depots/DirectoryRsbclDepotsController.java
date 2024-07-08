package org.excise.rsbcl.controllers.directory.rsbcl.depots;

import org.excise.rsbcl.model.directory.rsbcl.depots.DirectoryRsbclDepots;
import org.excise.rsbcl.services.directory.rsbcl.depots.DirectoryRsbclDepotsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/directory-rsbcl-depots")
public class DirectoryRsbclDepotsController {
    @Autowired
    private DirectoryRsbclDepotsService directoryRsbclDepotsService;

    @GetMapping
    public List<DirectoryRsbclDepots> getAll() {
        return directoryRsbclDepotsService.getAll();
    }
}
