package org.excise.rsbcl.controllers.directory.rsgsm.depots;

import org.bson.types.ObjectId;
import org.excise.rsbcl.model.directory.rsgsm.depots.DirectoryRsgsmDepots;
import org.excise.rsbcl.services.directory.rsgsm.depots.DirectoryRsgsmDepotsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DirectoryRsgsmDepotsController {
    @Autowired
    private final DirectoryRsgsmDepotsService directoryRsgsmDepotsService;

    public DirectoryRsgsmDepotsController(DirectoryRsgsmDepotsService directoryRsgsmDepotsService) {
        this.directoryRsgsmDepotsService = directoryRsgsmDepotsService;
    }

    @GetMapping("/v1/public/directory/rsgsm-depots")
    public ResponseEntity<?> getAll() {
        DirectoryRsgsmDepotsService.Response<List<DirectoryRsgsmDepots>> response = directoryRsgsmDepotsService.getAll();
        return createResponseEntity(response);
    }

    @GetMapping("/v1/auth/directory/rsgsm-depot/id/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") ObjectId id) {
        DirectoryRsgsmDepotsService.Response<DirectoryRsgsmDepots> response = directoryRsgsmDepotsService.getById(id);
        return createResponseEntity(response);
    }

    @PostMapping("/v1/auth/directory/rsgsm-depot")
    public ResponseEntity<?> saveDepot(@RequestBody DirectoryRsgsmDepots directoryRsgsmDepots) {
        DirectoryRsgsmDepotsService.Response<DirectoryRsgsmDepots> response = directoryRsgsmDepotsService.save(directoryRsgsmDepots);
        return createResponseEntity(response);
    }

    @PutMapping("/v1/auth/directory/rsgsm-depot/id/{id}")
    public ResponseEntity<?> updateById(@PathVariable("id") ObjectId id, @RequestBody DirectoryRsgsmDepots directoryRsgsmDepots) {
        DirectoryRsgsmDepotsService.Response<DirectoryRsgsmDepots> response = directoryRsgsmDepotsService.updateById(id, directoryRsgsmDepots);
        return createResponseEntity(response);
    }

    @DeleteMapping("/v1/auth/directory/rsgsm-depot/id/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") ObjectId id) {
        DirectoryRsgsmDepotsService.Response<Void> response = directoryRsgsmDepotsService.deleteById(id);
        return createResponseEntity(response);
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
