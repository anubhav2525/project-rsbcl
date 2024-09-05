package org.excise.rsbcl.controllers.mobileApp;

import org.bson.types.ObjectId;
import org.excise.rsbcl.dao.mobileApp.MobileAppDao;
import org.excise.rsbcl.model.mobileApp.MobileApp;
import org.excise.rsbcl.services.mobileApp.MobileAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MobileAppController {
    @Autowired
    private final MobileAppService mobileAppService;

    public MobileAppController(MobileAppService mobileAppService) {
        this.mobileAppService = mobileAppService;
    }

    @GetMapping("/v1/public/mobile-apps")
    public ResponseEntity<?> getAllMobileApps() {
        return createResponseEntity(mobileAppService.getMobileApps());
    }

    @GetMapping("/v1/public/mobile-apps-lists")
    public ResponseEntity<?> getPaginatedMobileApps(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return createResponseEntity(mobileAppService.getPaginatedMobileApps(page, size));
    }

    @GetMapping("/v1/auth/mobile-app/name/{name}")
    public ResponseEntity<?> getMobileAppByName(@PathVariable("name") String name) {
        return createResponseEntity(mobileAppService.getMobileAppByName(name));
    }

    @GetMapping("/v1/auth/mobile-app/id/{id}")
    public ResponseEntity<?> getMobileAppById(@PathVariable("id") ObjectId id) {
        MobileAppService.Response<MobileApp> response = mobileAppService.getMobileAppById(id);
        return createResponseEntity(response);
    }

    @PostMapping(value = "/v1/auth/mobile-app", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> saveMobileApp(@ModelAttribute MobileAppDao mobileAppDao) {
        return createResponseEntity(mobileAppService.saveMobileApp(mobileAppDao));
    }

    @PostMapping("/v1/auth/mobile-app/save-entries")
    public ResponseEntity<?> saveMobileApps(@RequestBody List<MobileApp> mobileApps) {
        return createResponseEntity(mobileAppService.saveMobileApps(mobileApps));
    }

    @PutMapping("/v1/auth/mobile-app/id/{id}")
    public ResponseEntity<?> updateMobileApp(@PathVariable("id") ObjectId id, @RequestBody MobileApp mobileApp) {
        return createResponseEntity(mobileAppService.updateMobileApp(id, mobileApp));
    }

    @DeleteMapping("/v1/auth/mobile-app/id/{id}")
    public ResponseEntity<?> deleteMobileAppById(@PathVariable("id") ObjectId id) {
        return createResponseEntity(mobileAppService.deleteMobileApp(id));
    }

    private <T> ResponseEntity<?> createResponseEntity(MobileAppService.Response<T> response) {
        return switch (response.getStatus()) {
            case "Error" -> new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            case "Success" -> new ResponseEntity<>(response, HttpStatus.OK);
            case "Saved" -> new ResponseEntity<>(response, HttpStatus.CREATED);
            case "Error404" -> new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            case "Error208" -> new ResponseEntity<>(response, HttpStatus.ALREADY_REPORTED);
            default ->
                    new ResponseEntity<>("Unknown status" + response.getMessage() + " /// " + response.getData(), HttpStatus.INTERNAL_SERVER_ERROR);
        };
    }

}
