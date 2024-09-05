package org.excise.rsbcl.controllers.directory.rsbcl.depots;

import org.bson.types.ObjectId;
import org.excise.rsbcl.model.directory.rsbcl.depots.DirectoryRsbclDepots;
import org.excise.rsbcl.services.directory.rsbcl.depots.DirectoryRsbclDepotsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DirectoryRsbclDepotsController {
    @Autowired
    private final DirectoryRsbclDepotsService directoryRsbclDepotsService;

    public DirectoryRsbclDepotsController(DirectoryRsbclDepotsService directoryRsbclDepotsService) {
        this.directoryRsbclDepotsService = directoryRsbclDepotsService;
    }

    @GetMapping("/v1/public/directory/rsbcl-depots")
    public ResponseEntity<?> getPaginatedDirectoryRSBCLDepots(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return createResponseEntity(directoryRsbclDepotsService.getPaginatedDirectoryRSBCLDepots(page, size));
    }

    @GetMapping("/v1/auth/directory/rsbcl-depot/id/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") ObjectId id) {
        DirectoryRsbclDepotsService.Response<DirectoryRsbclDepots> response = directoryRsbclDepotsService.getDepotsById(id);
        return createResponseEntity(response);
    }

    @PostMapping("/v1/auth/directory/rsbcl-depot")
    public ResponseEntity<?> saveDepot(@ModelAttribute DirectoryRsbclDepots directoryRsbclDepots) {
        DirectoryRsbclDepotsService.Response<DirectoryRsbclDepots> response = directoryRsbclDepotsService.saveDepot(directoryRsbclDepots);
        return createResponseEntity(response);
    }

    @PostMapping("/v1/auth/directory/rsbcl-depot/save-entries")
    public ResponseEntity<?> saveDepots(@RequestBody List<DirectoryRsbclDepots> directoryRsbclDepotsList) {
        DirectoryRsbclDepotsService.Response<List<DirectoryRsbclDepots>> response = directoryRsbclDepotsService.saveDepots(directoryRsbclDepotsList);
        return createResponseEntity(response);
    }

    @PutMapping("/v1/auth/directory/rsbcl-depot/id/{id}")
    public ResponseEntity<?> updateDepotById(@PathVariable("id") ObjectId id, @RequestBody DirectoryRsbclDepots directoryRsbclDepots) {
        DirectoryRsbclDepotsService.Response<DirectoryRsbclDepots> response = directoryRsbclDepotsService.updateDepot(id, directoryRsbclDepots);
        return createResponseEntity(response);
    }

    @DeleteMapping("/v1/auth/directory/rsbcl-depot/id/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") ObjectId id) {
        DirectoryRsbclDepotsService.Response<Void> response = directoryRsbclDepotsService.deleteById(id);
        return createResponseEntity(response);
    }

    private <T> ResponseEntity<?> createResponseEntity(DirectoryRsbclDepotsService.Response<T> response) {
        return switch (response.getStatus()) {
            case "Success" -> new ResponseEntity<>(response, HttpStatus.OK);
            case "Error" -> new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            case "Error404" -> new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            default -> new ResponseEntity<>("Unknown status", HttpStatus.INTERNAL_SERVER_ERROR);
        };
    }
}
