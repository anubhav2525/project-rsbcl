package org.excise.rsbcl.controllers.directory.rsbcl.office;

import org.bson.types.ObjectId;
import org.excise.rsbcl.model.directory.rsbcl.office.DirectoryRsbclOffice;
import org.excise.rsbcl.services.directory.rsbcl.office.DirectoryRsbclOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DirectoryRsbclOfficeController {
    @Autowired
    private final DirectoryRsbclOfficeService directoryRsbclOfficeService;

    public DirectoryRsbclOfficeController(DirectoryRsbclOfficeService directoryRsbclOfficeService) {
        this.directoryRsbclOfficeService = directoryRsbclOfficeService;
    }

    @GetMapping("/v1/public/directory/rsbcl-offices")
    public ResponseEntity<?> getPaginatedDirectoryRSBCLOffice(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return createResponseEntity(directoryRsbclOfficeService.getPaginatedDirectoryRSBCLOffice(page, size));
    }

    @GetMapping("/v1/auth/directory/rsbcl-office/id/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") ObjectId id) {
        DirectoryRsbclOfficeService.Response<DirectoryRsbclOffice> response = directoryRsbclOfficeService.getOfficeById(id);
        return createResponseEntity(response);
    }

    @DeleteMapping("/v1/auth/directory/rsbcl-office/id/{id}")
    public ResponseEntity<?> deletById(@PathVariable("id") ObjectId id) {
        DirectoryRsbclOfficeService.Response<Void> response = directoryRsbclOfficeService.deleteById(id);
        return createResponseEntity(response);
    }

    @PutMapping("/v1/public/directory/rsbcl-office/id/{id}")
    public ResponseEntity<?> updateById(@PathVariable("id") ObjectId id, @RequestBody DirectoryRsbclOffice directoryRsbclOffice) {
        DirectoryRsbclOfficeService.Response<DirectoryRsbclOffice> response = directoryRsbclOfficeService.updateDepotById(id, directoryRsbclOffice);
        return createResponseEntity(response);
    }

    @PostMapping("/v1/auth/directory/rsbcl-office")
    public ResponseEntity<?> saveDirectory(@ModelAttribute DirectoryRsbclOffice directoryRsbclOffice) {
        DirectoryRsbclOfficeService.Response<DirectoryRsbclOffice> response = directoryRsbclOfficeService.saveDirectory(directoryRsbclOffice);
        return createResponseEntity(response);
    }

    @PostMapping("/v1/auth/directory/rsbcl-office/save-entries")
    public ResponseEntity<?> saveDirectories(@RequestBody List<DirectoryRsbclOffice> directoryRsbclOffices) {
        DirectoryRsbclOfficeService.Response<List<DirectoryRsbclOffice>> response = directoryRsbclOfficeService.saveDirectories(directoryRsbclOffices);
        return createResponseEntity(response);
    }

    private <T> ResponseEntity<?> createResponseEntity(DirectoryRsbclOfficeService.Response<T> response) {
        return switch (response.getStatus()) {
            case "Success" -> new ResponseEntity<>(response, HttpStatus.OK);
            case "Error" -> new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            case "Error404" -> new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            default -> new ResponseEntity<>("Unknown status", HttpStatus.INTERNAL_SERVER_ERROR);
        };
    }
}
