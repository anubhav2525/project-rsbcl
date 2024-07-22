package org.excise.rsbcl.controllers.about.rsgsm.salesData;

import org.excise.rsbcl.model.about.rsgsm.salesData.AboutRsgsmSalesData;
import org.excise.rsbcl.services.about.rsgsm.salesData.AboutRsgsmSalesDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/about-rsgsm/")
public class AboutRsgsmSalesDataController {
    @Autowired
    private final AboutRsgsmSalesDataService aboutRsgsmSalesDataService;

    public AboutRsgsmSalesDataController(AboutRsgsmSalesDataService aboutRsgsmSalesDataService) {
        this.aboutRsgsmSalesDataService = aboutRsgsmSalesDataService;
    }

    @GetMapping("sales-data")
    public ResponseEntity<List<AboutRsgsmSalesData>> getAll() {
        List<AboutRsgsmSalesData> aboutRsgsmSalesData = aboutRsgsmSalesDataService.getAll();
        if (aboutRsgsmSalesData.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(aboutRsgsmSalesData, HttpStatus.OK);
    }
}
