package org.excise.rsbcl.controllers.about.rsbcl.introduction;

import org.excise.rsbcl.model.about.rsbcl.introduction.AboutRsbclIntroduction;
import org.excise.rsbcl.services.about.rsbcl.introduction.AboutRsbclIntroductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AboutRsbclIntroductionController {
    @Autowired
    private final AboutRsbclIntroductionService aboutRsbclIntroductionService;

    public AboutRsbclIntroductionController(AboutRsbclIntroductionService aboutRsbclIntroductionService) {
        this.aboutRsbclIntroductionService = aboutRsbclIntroductionService;
    }

    @GetMapping("/v1/public/about/rsbcl-introductions")
    public ResponseEntity<?> getAll() {
        AboutRsbclIntroductionService.Response<List<AboutRsbclIntroduction>> response = aboutRsbclIntroductionService.getAll();
        return createResponseEntity(response);
    }

    private <T> ResponseEntity<?> createResponseEntity(AboutRsbclIntroductionService.Response<T> response) {
        return switch (response.getStatus()) {
            case "Success" -> new ResponseEntity<>(response, HttpStatus.OK);
            case "Error" -> new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            case "Error404" -> new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            default -> new ResponseEntity<>("Unknown status", HttpStatus.INTERNAL_SERVER_ERROR);
        };
    }
}
