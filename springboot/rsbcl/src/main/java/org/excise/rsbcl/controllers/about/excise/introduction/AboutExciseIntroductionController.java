package org.excise.rsbcl.controllers.about.excise.introduction;

import org.excise.rsbcl.model.about.excise.introduction.AboutExciseIntroduction;
import org.excise.rsbcl.services.about.excise.introduction.AboutExciseIntroductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AboutExciseIntroductionController {
    @Autowired
    private final AboutExciseIntroductionService aboutExciseIntroductionService;

    public AboutExciseIntroductionController(AboutExciseIntroductionService aboutExciseIntroductionService) {
        this.aboutExciseIntroductionService = aboutExciseIntroductionService;
    }

    @GetMapping("/v1/public/about/excise-introduction")
    public ResponseEntity<?> getAll() {
       AboutExciseIntroductionService.Response<List<AboutExciseIntroduction>> response = aboutExciseIntroductionService.getAll();
       return createResponseEntity(response);
    }

    private <T> ResponseEntity<?> createResponseEntity(AboutExciseIntroductionService.Response<T> response) {
        return switch (response.getStatus()) {
            case "Success" -> new ResponseEntity<>(response, HttpStatus.OK);
            case "Error" -> new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            case "Error404" -> new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            default -> new ResponseEntity<>("Unknown status", HttpStatus.INTERNAL_SERVER_ERROR);
        };
    }
}
