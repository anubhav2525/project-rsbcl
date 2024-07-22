package org.excise.rsbcl.controllers.about.rsgsm.management;

import org.excise.rsbcl.model.about.rsgsm.management.AboutRsgsmManagement;
import org.excise.rsbcl.services.about.rsgsm.management.AboutRsgsmManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/about-rsgsm/")
public class AboutRsgsmManagementController {
    @Autowired
    private final AboutRsgsmManagementService aboutRsgsmManagementService;

    public AboutRsgsmManagementController(AboutRsgsmManagementService aboutRsgsmManagementService) {
        this.aboutRsgsmManagementService = aboutRsgsmManagementService;
    }

    @GetMapping("management")
    public ResponseEntity<List<AboutRsgsmManagement>> getAll() {
        List<AboutRsgsmManagement> aboutRsgsmManagements = aboutRsgsmManagementService.getAll();
        if (aboutRsgsmManagements.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(aboutRsgsmManagements, HttpStatus.OK);
    }
}
