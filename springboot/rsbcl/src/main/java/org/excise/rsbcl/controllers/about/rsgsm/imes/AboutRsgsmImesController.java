package org.excise.rsbcl.controllers.about.rsgsm.imes;

import org.excise.rsbcl.model.about.rsgsm.imes.AboutRsgsmImes;
import org.excise.rsbcl.services.about.rsgsm.imes.AboutRsgsmImesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/about-rsgsm/")
public class AboutRsgsmImesController {
    @Autowired
    private final AboutRsgsmImesService aboutRsgsmImesService;

    public AboutRsgsmImesController(AboutRsgsmImesService aboutRsgsmImesService) {
        this.aboutRsgsmImesService = aboutRsgsmImesService;
    }

    @GetMapping("imes")
    public ResponseEntity<List<AboutRsgsmImes>> getAll() {
        List<AboutRsgsmImes> aboutRsgsmImes = aboutRsgsmImesService.getAll();
        if (aboutRsgsmImes.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(aboutRsgsmImes, HttpStatus.OK);
    }
}
