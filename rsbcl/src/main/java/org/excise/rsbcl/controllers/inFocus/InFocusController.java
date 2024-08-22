package org.excise.rsbcl.controllers.inFocus;

import org.excise.rsbcl.services.inFocus.InFocusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class InFocusController {
    @Autowired
    private final InFocusService inFocusService;

    public InFocusController(InFocusService inFocusService) {
        this.inFocusService = inFocusService;
    }


}
