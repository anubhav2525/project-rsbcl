package org.excise.rsbcl.controllers.inFocus;

import org.bson.types.ObjectId;
import org.excise.rsbcl.model.inFocus.InFocus;
import org.excise.rsbcl.services.inFocus.InFocusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class InFocusController {
    @Autowired
    private final InFocusService inFocusService;

    public InFocusController(InFocusService inFocusService) {
        this.inFocusService = inFocusService;
    }

    @GetMapping("/public/inFocuses")
    public ResponseEntity<?> getAll() {
        return createResponseEntity(inFocusService.getAll());
    }

    @GetMapping("/auth/inFocus/id/{id}")
    public ResponseEntity<?> getInFocusById(@PathVariable ObjectId id) {
        return createResponseEntity(inFocusService.getInFocusById(id));
    }

    @PostMapping("/auth/inFocus")
    public ResponseEntity<?> saveInFocus(@ModelAttribute InFocus inFocus, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }
        return createResponseEntity(inFocusService.saveInFocus(inFocus));
    }

    @PutMapping("/auth/inFocus/id/{id}")
    public ResponseEntity<?> updateInFocus(@PathVariable ObjectId id, @ModelAttribute InFocus inFocus) {
        return createResponseEntity(inFocusService.updateInFocusById(id, inFocus));
    }

    @DeleteMapping("/auth/inFocus/id/{id}")
    public ResponseEntity<?> deleteInFocus(@PathVariable ObjectId id) {
        return createResponseEntity(inFocusService.deleteInFocusById(id));
    }

    private <T> ResponseEntity<?> createResponseEntity(InFocusService.Response<T> response) {
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
