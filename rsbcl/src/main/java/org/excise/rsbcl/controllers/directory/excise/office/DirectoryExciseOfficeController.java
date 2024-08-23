package org.excise.rsbcl.controllers.directory.excise.office;

import org.bson.types.ObjectId;
import org.excise.rsbcl.model.directory.excise.office.DirectoryExciseOffice;
import org.excise.rsbcl.services.directory.excise.office.DirectoryExciseOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DirectoryExciseOfficeController {
    @Autowired
    private final DirectoryExciseOfficeService directoryExciseOfficeService;

    public DirectoryExciseOfficeController(DirectoryExciseOfficeService directoryExciseOfficeService) {
        this.directoryExciseOfficeService = directoryExciseOfficeService;
    }

    @GetMapping("/v1/public/directory/excise-offices")
    public ResponseEntity<?> getPaginatedDirectoryExcise(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return createResponseEntity(directoryExciseOfficeService.getPaginatedDirectoryExcise(page, size));
    }

    @GetMapping("/v1/auth/directory/excise-office/id/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") ObjectId id) {
        DirectoryExciseOfficeService.Response<DirectoryExciseOffice> response = directoryExciseOfficeService.getDirectoryById(id);
        return createResponseEntity(response);
    }

    @PostMapping("/v1/auth/directory/excise-office")
    public ResponseEntity<?> saveDirectory(@RequestBody DirectoryExciseOffice directoryExciseOffice) {
        DirectoryExciseOfficeService.Response<DirectoryExciseOffice> response = directoryExciseOfficeService.saveDirectory(directoryExciseOffice);
        return createResponseEntity(response);
    }

    @PostMapping("/v1/auth/directory/excise-office/save-entries")
    public ResponseEntity<?> saveDirectories(@RequestBody List<DirectoryExciseOffice> directoryExciseOfficeList) {
        DirectoryExciseOfficeService.Response<List<DirectoryExciseOffice>> response = directoryExciseOfficeService.saveDirectories(directoryExciseOfficeList);
        return createResponseEntity(response);
    }

    @PutMapping("/v1/auth/directory/excise-office/id/{id}")
    public ResponseEntity<?> updateDirectoryById(@PathVariable("id") ObjectId id, @RequestBody DirectoryExciseOffice directoryExciseOffice) {
        DirectoryExciseOfficeService.Response<DirectoryExciseOffice> response = directoryExciseOfficeService.updateDirectory(id, directoryExciseOffice);
        return createResponseEntity(response);
    }

    @DeleteMapping("/v1/auth/directory/excise-office/id/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") ObjectId id) {
        DirectoryExciseOfficeService.Response<Void> response = directoryExciseOfficeService.deleteById(id);
        return createResponseEntity(response);
    }

    private <T> ResponseEntity<?> createResponseEntity(DirectoryExciseOfficeService.Response<T> response) {
        return switch (response.getStatus()) {
            case "Success" -> new ResponseEntity<>(response, HttpStatus.OK);
            case "Error" -> new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            case "Error404" -> new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            case "Error208" -> new ResponseEntity<>(response, HttpStatus.ALREADY_REPORTED);
            default -> new ResponseEntity<>("Unknown status", HttpStatus.INTERNAL_SERVER_ERROR);
        };
    }
}
