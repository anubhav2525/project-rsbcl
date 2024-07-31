package org.excise.rsbcl.controllers.about.rsbcl.directors;

import org.excise.rsbcl.model.about.rsbcl.directors.AboutRsbclDirector;
import org.excise.rsbcl.services.about.rsbcl.directors.AboutRsbclDirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AboutRsbclDirectorController {
    @Autowired
    private final AboutRsbclDirectorService aboutRsbclDirectorService;

    public AboutRsbclDirectorController(AboutRsbclDirectorService aboutRsbclDirectorService) {
        this.aboutRsbclDirectorService = aboutRsbclDirectorService;
    }

    @GetMapping("/v1/public/about/rsbcl-directors")
    public ResponseEntity<?> getAll() {
        AboutRsbclDirectorService.Response<List<AboutRsbclDirector>> response = aboutRsbclDirectorService.getAll();
        return createResponseEntity(response);
    }

    private <T> ResponseEntity<?> createResponseEntity(AboutRsbclDirectorService.Response<T> response) {
        return switch (response.getStatus()) {
            case "Success" -> new ResponseEntity<>(response, HttpStatus.OK);
            case "Error" -> new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            case "Error404" -> new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            default -> new ResponseEntity<>("Unknown status", HttpStatus.INTERNAL_SERVER_ERROR);
        };
    }
}
