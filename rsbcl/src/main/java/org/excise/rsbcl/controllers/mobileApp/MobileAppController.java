package org.excise.rsbcl.controllers.mobileApp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.bson.types.ObjectId;
import org.excise.rsbcl.dao.MobileAppDao;
import org.excise.rsbcl.model.mobileApp.MobileApp;
import org.excise.rsbcl.services.mobileApp.MobileAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    @GetMapping("/v1/auth/mobile-app/name/{name}")
    public ResponseEntity<?> getMobileAppByName(@PathVariable("name") String name) {
        MobileAppService.Response<MobileApp> response = mobileAppService.getMobileAppByName(name);
        return createResponseEntity(response);
    }

    @GetMapping("/v1/auth/mobile-app/id/{id}")
    public ResponseEntity<?> getMobileAppById(@PathVariable("id") ObjectId id) {
        MobileAppService.Response<MobileApp> response = mobileAppService.getMobileAppById(id);
        return createResponseEntity(response);
    }

    @PostMapping(value = "/v1/auth/mobile-app", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveMobileApp(@RequestPart("jsonData") String jsonData,
                                           @RequestPart("document") MultipartFile document,
                                           @RequestPart("video") MultipartFile video,
                                           @RequestPart("applicationImage") MultipartFile applicationImage)
            throws JsonProcessingException {
        try {
            // Convert jsonData string to MobileAppDao object
            ObjectMapper objectMapper = new ObjectMapper();
            MobileAppDao mobileApp = objectMapper.readValue(jsonData, MobileAppDao.class);

            // Set multipart files to MobileAppDao
            mobileApp.setDocument(document);
            mobileApp.setVideo(video);
            mobileApp.setApplicationImage(applicationImage);

            // Call service to save the data
            MobileAppService.Response<MobileApp> response = mobileAppService.saveMobileApp(mobileApp);
            return createResponseEntity(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
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
    public ResponseEntity<?> deleteMobileAppById(@PathVariable("id") ObjectId id) {
        MobileAppService.Response<Void> response = mobileAppService.deleteMobileApp(id);
        return createResponseEntity(response);
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
