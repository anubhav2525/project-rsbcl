package org.excise.rsbcl.controllers;

import org.excise.rsbcl.services.emailService.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheck {
    @Autowired
    private final EmailService emailService;

    public HealthCheck(EmailService emailService) {
        this.emailService = emailService;
    }


    @GetMapping("/api/v1/public/health-check")
    public String healthcheck() {
        return "status :ok";
    }


    @PostMapping("/api/v1/public/send")
    public ResponseEntity<EmailService.Response<Void>> sendEmail(@RequestBody EmailService.EmailRequest emailRequest) {
        EmailService.Response<Void> response = emailService.sendEmail(emailRequest.getTo(), emailRequest.getSubject(), emailRequest.getBody());
        return ResponseEntity.ok(response);
    }

}
