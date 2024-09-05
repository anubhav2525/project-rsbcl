package org.excise.rsbcl.controllers.serviceProviders;

import org.bson.types.ObjectId;
import org.excise.rsbcl.model.serviceProviders.ServiceProviders;
import org.excise.rsbcl.services.serviceProviders.ServiceProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class ServiceProviderController {
    @Autowired
    private final ServiceProviderService serviceProviderService;

    public ServiceProviderController(ServiceProviderService serviceProviderService) {
        this.serviceProviderService = serviceProviderService;
    }

    @GetMapping("/public/services")
    public ResponseEntity<?> getAllServices(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return createResponseEntity(serviceProviderService.getAllServices(page, size));
    }

    // for home page
    @GetMapping("/public/services-lists")
    public ResponseEntity<?> getAllServicesList() {
        return createResponseEntity(serviceProviderService.getAllServicesList());
    }

    @PostMapping("/auth/services")
    public ResponseEntity<?> saveService(@ModelAttribute ServiceProviders serviceProviders) {
        return createResponseEntity(serviceProviderService.saveService(serviceProviders));
    }

    @GetMapping("/auth/services/id/{id}")
    public ResponseEntity<?> getServiceById(@PathVariable ObjectId id) {
        return createResponseEntity(serviceProviderService.getServiceById(id));
    }

    @PutMapping("/auth/services/id/{id}")
    public ResponseEntity<?> updateService(@PathVariable ObjectId id, @ModelAttribute ServiceProviders serviceProviders) {
        return createResponseEntity(serviceProviderService.updateServiceById(id, serviceProviders));
    }

    @DeleteMapping("/auth/services/id/{id}")
    public ResponseEntity<?> deleteServiceById(@PathVariable ObjectId id) {
        return createResponseEntity(serviceProviderService.deleteServiceById(id));
    }

    private <T> ResponseEntity<?> createResponseEntity(ServiceProviderService.Response<T> response) {
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
