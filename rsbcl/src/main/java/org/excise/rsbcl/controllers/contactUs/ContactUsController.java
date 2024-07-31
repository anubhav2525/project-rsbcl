package org.excise.rsbcl.controllers.contactUs;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Valid;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.bson.types.ObjectId;
import org.excise.rsbcl.model.contactUs.ContactUs;
import org.excise.rsbcl.services.contactUs.ContactUsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class ContactUsController {
    @Autowired
    private final ContactUsService contactUsService;

    public ContactUsController(ContactUsService contactUsService) {
        this.contactUsService = contactUsService;
    }

    @GetMapping("/v1/public/contacts")
    public ResponseEntity<?> getAllContactUses() {
        ContactUsService.Response<List<ContactUs>> response = contactUsService.getAllContactUs();
        return createResponseEntity(response);
    }

    @GetMapping("/v1/auth/contact/id/{id}")
    public ResponseEntity<?> getContactUsById(@PathVariable("id") ObjectId id) {
        ContactUsService.Response<ContactUs> response = contactUsService.getContactUsById(id);
        return createResponseEntity(response);
    }

    @PostMapping("/v1/auth/contact")
    public ResponseEntity<?> saveContactUs(@Valid @RequestBody ContactUs contactUs, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }
        ContactUsService.Response<ContactUs> response = contactUsService.saveContactUs(contactUs);
        return createResponseEntity(response);
    }

    @PostMapping("/v1/auth/contact/save-entries")
    public ResponseEntity<?> saveContactUsList(@Valid @RequestBody List<ContactUs> contactUsList,BindingResult bindingResult) {
        // error validation
        List<ObjectError> allErrors = new ArrayList<>(bindingResult.getAllErrors());
        for (int i = 0; i < contactUsList.size(); i++) {
            ContactUs contactUs = contactUsList.get(i);
            BindingResult contactBindingResult = new BeanPropertyBindingResult(contactUs, "contactList[" + i + "]");
            Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
            Set<ConstraintViolation<ContactUs>> violations = validator.validate(contactUs);
            for (ConstraintViolation<ContactUs> violation : violations) {
                allErrors.add(new ObjectError("contactList[" + i + "]." + violation.getPropertyPath(), violation.getMessage()));
            }
        }
        if (!allErrors.isEmpty()) {
            return ResponseEntity.badRequest().body(allErrors);
        }

        // call the respective method
        ContactUsService.Response<List<ContactUs>> response = contactUsService.saveContactUses(contactUsList);
        return createResponseEntity(response);
    }

    @PutMapping("/v1/auth/contact/id/{id}")
    public ResponseEntity<?> updateContactUs(@PathVariable("id") ObjectId id, @RequestBody ContactUs contactUs) {
        ContactUsService.Response<ContactUs> response = contactUsService.updateContactUs(id, contactUs);
        return createResponseEntity(response);
    }

    @DeleteMapping("/v1/auth/contact/id/{id}")
    public ResponseEntity<?> deleteContactUs(@PathVariable("id") ObjectId id) {
        ContactUsService.Response<Void> response = contactUsService.deleteContactUs(id);
        return createResponseEntity(response);
    }

    private <T> ResponseEntity<?> createResponseEntity(ContactUsService.Response<T> response) {
        if (response.getStatus().equals("Success")) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else if (response.getStatus().equals("Error")) {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Unknown status", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
