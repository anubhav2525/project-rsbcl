package org.excise.rsbcl.controllers.actsPolicies;

import org.bson.types.ObjectId;
import org.excise.rsbcl.dao.actsPolicies.ActsPoliciesDAO;
import org.excise.rsbcl.services.actsPolicies.ActsPoliciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class ActsPoliciesController {
    @Autowired
    private final ActsPoliciesService actsPoliciesService;

    public ActsPoliciesController(ActsPoliciesService actsPoliciesService) {
        this.actsPoliciesService = actsPoliciesService;
    }

    // Endpoint to get paginated data
    @GetMapping("/public/acts-policies")
    public ResponseEntity<?> getPaginatedActsPolicies(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return createResponseEntity(actsPoliciesService.getPaginatedActsPolicies(page, size));
    }

    @GetMapping("/public/acts-policies/latest-five/{department}")
    public ResponseEntity<?> getLatestFiveActsPolicies(@PathVariable String department) {
        return createResponseEntity(actsPoliciesService.getActsPoliciesFive(department));
    }

    @PostMapping(value = "/auth/acts-policies", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> saveActsPolicies(@ModelAttribute ActsPoliciesDAO actsPoliciesDAO) {
        return createResponseEntity(actsPoliciesService.saveActsPolicies(actsPoliciesDAO));
    }

    @PutMapping("/auth/acts-policies/{id}")
    public ResponseEntity<?> updateActsPolicies(@PathVariable ObjectId id, @ModelAttribute ActsPoliciesDAO actsPoliciesDAO) {
        return createResponseEntity(actsPoliciesService.updateActsPolicies(id, actsPoliciesDAO));
    }

    @DeleteMapping("/auth/acts-policies/{id}")
    public ResponseEntity<?> deleteActsPolicies(@PathVariable ObjectId id) {
        return createResponseEntity(actsPoliciesService.deleteActsPolicies(id));
    }

    private <T> ResponseEntity<?> createResponseEntity(ActsPoliciesService.Response<T> response) {
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
