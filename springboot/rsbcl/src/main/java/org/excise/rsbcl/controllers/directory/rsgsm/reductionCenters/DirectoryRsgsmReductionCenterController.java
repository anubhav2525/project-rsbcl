package org.excise.rsbcl.controllers.directory.rsgsm.reductionCenters;

import org.bson.types.ObjectId;
import org.excise.rsbcl.model.directory.rsgsm.reductionCenters.DirectoryRsgsmReductionCenter;
import org.excise.rsbcl.services.directory.rsgsm.reductionCenters.DirectoryRsgsmReductionCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DirectoryRsgsmReductionCenterController {
    @Autowired
    private final DirectoryRsgsmReductionCenterService directoryRsgsmReductionCenterService;

    public DirectoryRsgsmReductionCenterController(DirectoryRsgsmReductionCenterService directoryRsgsmReductionCenterService) {
        this.directoryRsgsmReductionCenterService = directoryRsgsmReductionCenterService;
    }

    @GetMapping("/v1/public/directory/rsgsm-reductionCenters")
    public ResponseEntity<?> getAllRecords() {
        DirectoryRsgsmReductionCenterService.Response<List<DirectoryRsgsmReductionCenter>> response = directoryRsgsmReductionCenterService.getAll();
        return createResponseEntity(response);
    }

    @GetMapping("/v1/auth/directory/rsgsm-reductionCenter/id/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") ObjectId id) {
        DirectoryRsgsmReductionCenterService.Response<DirectoryRsgsmReductionCenter> response = directoryRsgsmReductionCenterService.getById(id);
        return createResponseEntity(response);
    }

    @PostMapping("/v1/auth/directory/rsgsm-reductionCenter")
    public ResponseEntity<?> saveRc(@RequestBody DirectoryRsgsmReductionCenter directoryRsgsmReductionCenter) {
        DirectoryRsgsmReductionCenterService.Response<DirectoryRsgsmReductionCenter> response = directoryRsgsmReductionCenterService.save(directoryRsgsmReductionCenter);
        return createResponseEntity(response);
    }

    @DeleteMapping("/v1/auth/directory/rsgsm-reductionCenter/id/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") ObjectId id) {
        DirectoryRsgsmReductionCenterService.Response<Void> response = directoryRsgsmReductionCenterService.deleteById(id);
        return createResponseEntity(response);
    }

    @DeleteMapping("/v1/auth/directory/rsgsm-reductionCenter/email/{email}")
    public ResponseEntity<?> deleteByEmail(@PathVariable("email") String email) {
        DirectoryRsgsmReductionCenterService.Response<Void> response = directoryRsgsmReductionCenterService.deleteByEmail(email);
        return createResponseEntity(response);
    }

    @PutMapping("/v1/auth/directory/rsgsm-reductionCenter/id/{id}")
    public ResponseEntity<?> updateById(@PathVariable("id") ObjectId id, @RequestBody DirectoryRsgsmReductionCenter directoryRsgsmReductionCenter) {
        DirectoryRsgsmReductionCenterService.Response<DirectoryRsgsmReductionCenter> response = directoryRsgsmReductionCenterService.updateById(id, directoryRsgsmReductionCenter);
        return createResponseEntity(response);
    }

    @PutMapping("/v1/auth/directory/rsgsm-reductionCenter/email/{email}")
    public ResponseEntity<?> updateByEmail(@PathVariable("email") String email, @RequestBody DirectoryRsgsmReductionCenter directoryRsgsmReductionCenter) {
        DirectoryRsgsmReductionCenterService.Response<DirectoryRsgsmReductionCenter> response = directoryRsgsmReductionCenterService.updateByEmail(email, directoryRsgsmReductionCenter);
        return createResponseEntity(response);
    }

    private <T> ResponseEntity<?> createResponseEntity(DirectoryRsgsmReductionCenterService.Response<T> response) {
        return switch (response.getStatus()) {
            case "Success" -> new ResponseEntity<>(response, HttpStatus.OK);
            case "Error" -> new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            case "Error208" -> new ResponseEntity<>(response, HttpStatus.ALREADY_REPORTED);
            case "Error404" -> new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            default -> new ResponseEntity<>("Unknown status", HttpStatus.INTERNAL_SERVER_ERROR);
        };
    }
}
