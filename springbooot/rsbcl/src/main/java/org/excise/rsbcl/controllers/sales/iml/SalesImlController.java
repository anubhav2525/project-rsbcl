package org.excise.rsbcl.controllers.sales.iml;

import org.excise.rsbcl.model.sales.iml.SalesIml;
import org.excise.rsbcl.services.sales.iml.SalesImlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sales/")
public class SalesImlController {
    @Autowired
    private SalesImlService salesImlService;

    @GetMapping("iml")
    public List<SalesIml> getAll() {
        return salesImlService.getAll();
    }

    @GetMapping("iml/{year}")
    public List<SalesIml> getSalesImlByYear(@PathVariable int year) {
        return salesImlService.getSalesImlByYear(year);
    }
}
