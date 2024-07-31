package org.excise.rsbcl.controllers.mobileApp;

import org.bson.types.ObjectId;
import org.excise.rsbcl.model.mobileApp.MobileApp;
import org.excise.rsbcl.services.mobileApp.MobileAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
        MobileAppService.Response<List<MobileApp>> response = mobileAppService.getMobileApps();
        return createResponseEntity(response);
    }

    @GetMapping("/v1/auth/mobile-app/id/{id}")
    public ResponseEntity<?> getMobileAppById(@PathVariable("id") ObjectId id) {
        MobileAppService.Response<MobileApp> response = mobileAppService.getMobileAppById(id);
        return createResponseEntity(response);
    }

    @PostMapping("/v1/auth/mobile-app")
    public ResponseEntity<?> saveMobileApp(@RequestBody MobileApp mobileApp) {
        MobileAppService.Response<MobileApp> response = mobileAppService.saveMobileApp(mobileApp);
        return createResponseEntity(response);
    }

    @PostMapping("/v1/auth/mobile-app/save-entries")
    public ResponseEntity<?> saveMobileApps(@RequestBody List<MobileApp> mobileApps) {
        MobileAppService.Response<List<MobileApp>> response = mobileAppService.saveMobileApps(mobileApps);
        return createResponseEntity(response);
    }

    @PutMapping("/v1/auth/mobile-app/id/{id}")
    public ResponseEntity<?> updateMobileApp(@PathVariable("id") ObjectId id, @RequestBody MobileApp mobileApp) {
        MobileAppService.Response<MobileApp> response = mobileAppService.updateMobileApp(id, mobileApp);
        return createResponseEntity(response);
    }

    @DeleteMapping("/v1/auth/mobile-app/id/{id}")
    public ResponseEntity<?> deleteMobileApp(@PathVariable("id") ObjectId id) {
        MobileAppService.Response<Void> response = mobileAppService.deleteMobileApp(id);
        return createResponseEntity(response);
    }

    private <T> ResponseEntity<?> createResponseEntity(MobileAppService.Response<T> response) {
        if (response.getStatus().equals("Success")) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else if (response.getStatus().equals("Error")) {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Unknown status", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
