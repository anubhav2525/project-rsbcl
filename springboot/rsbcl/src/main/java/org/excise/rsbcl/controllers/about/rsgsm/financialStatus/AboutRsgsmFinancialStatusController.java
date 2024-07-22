package org.excise.rsbcl.controllers.about.rsgsm.financialStatus;

import org.excise.rsbcl.model.about.rsgsm.financialStatus.AboutRsgsmFinancialStatus;
import org.excise.rsbcl.services.about.rsgsm.financialStatus.AboutRsgsmFinancialStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.ls.LSInput;

import java.util.List;

@RestController
@RequestMapping("/api/v1/about-rsgsm/")
public class AboutRsgsmFinancialStatusController {
    @Autowired
    private final AboutRsgsmFinancialStatusService aboutRsgsmFinancialStatusService;

    public AboutRsgsmFinancialStatusController(AboutRsgsmFinancialStatusService aboutRsgsmFinancialStatusService) {
        this.aboutRsgsmFinancialStatusService = aboutRsgsmFinancialStatusService;
    }

    @GetMapping("financial-status")
    public ResponseEntity<List<AboutRsgsmFinancialStatus>> getAll() {
        List<AboutRsgsmFinancialStatus> aboutRsgsmFinancialStatuses = aboutRsgsmFinancialStatusService.getAll();
        if (aboutRsgsmFinancialStatuses.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(aboutRsgsmFinancialStatuses, HttpStatus.OK);
    }
}