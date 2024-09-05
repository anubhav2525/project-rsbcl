package org.excise.rsbcl.controllers.directory.rsgsm.depots;

import org.bson.types.ObjectId;
import org.excise.rsbcl.model.directory.rsgsm.depots.DirectoryRsgsmDepots;
import org.excise.rsbcl.services.directory.rsgsm.depots.DirectoryRsgsmDepotsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class DirectoryRsgsmDepotsController {
    @Autowired
    private final DirectoryRsgsmDepotsService directoryRsgsmDepotsService;

    public DirectoryRsgsmDepotsController(DirectoryRsgsmDepotsService directoryRsgsmDepotsService) {
        this.directoryRsgsmDepotsService = directoryRsgsmDepotsService;
    }

    @GetMapping("/v1/public/directory/rsgsm-depots")
    public ResponseEntity<?> getPaginatedDirectoryRSGSMDepots(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return createResponseEntity(directoryRsgsmDepotsService.getPaginatedDirectoryRSGSMDepots(page, size));
    }

    @GetMapping("/v1/auth/directory/rsgsm-depot/id/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") ObjectId id) {
        return createResponseEntity(directoryRsgsmDepotsService.getById(id));
    }

    @PostMapping("/v1/auth/directory/rsgsm-depot")
    public ResponseEntity<?> saveDepot(@RequestBody DirectoryRsgsmDepots directoryRsgsmDepots) {
        return createResponseEntity(directoryRsgsmDepotsService.saveDirectory(directoryRsgsmDepots));
    }

    @PutMapping("/v1/auth/directory/rsgsm-depot/id/{id}")
    public ResponseEntity<?> updateById(@PathVariable("id") ObjectId id, @RequestBody DirectoryRsgsmDepots directoryRsgsmDepots) {
        return createResponseEntity(directoryRsgsmDepotsService.updateById(id, directoryRsgsmDepots));
    }

    @DeleteMapping("/v1/auth/directory/rsgsm-depot/id/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") ObjectId id) {
        return createResponseEntity(directoryRsgsmDepotsService.deleteById(id));
    }

    private <T> ResponseEntity<?> createResponseEntity(DirectoryRsgsmDepotsService.Response<T> response) {
        return switch (response.getStatus()) {
            case "Success" -> new ResponseEntity<>(response, HttpStatus.OK);
            case "Error" -> new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            case "Error404" -> new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            default -> new ResponseEntity<>("Unknown status", HttpStatus.INTERNAL_SERVER_ERROR);
        };
    }
}
