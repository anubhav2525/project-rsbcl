package org.excise.rsbcl.controllers.sales.rml;

import org.excise.rsbcl.model.sales.rml.SalesRml;
import org.excise.rsbcl.services.sales.rml.SalesRmlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sales/")
public class SalesRmlController {
    @Autowired
    private SalesRmlService salesRmlService;

    @GetMapping("rml")
    public List<SalesRml> getAll() {
        return salesRmlService.getAll();
    }

    @GetMapping("rml/{year}")
    public List<SalesRml> getSalesRmlByYear(@PathVariable int year) {
        return salesRmlService.getSalesRmlByYear(year);
    }

}
