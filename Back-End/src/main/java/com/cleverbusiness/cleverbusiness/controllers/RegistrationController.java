package com.cleverbusiness.cleverbusiness.controllers;

import com.cleverbusiness.cleverbusiness.services.RegistrationService;
import jakarta.servlet.Registration;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {
        @Autowired
    RegistrationService registrationService;

    @GetMapping("/registrations/registersList")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(registrationService.getAll());
    }

    @GetMapping("/registrations/getRegistration")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Registration> getRegistration(@RequestBody Long idRegistration) {
        return ResponseEntity.status(HttpStatus.OK).body(registrationService.getRegistration(idRegistration));
    }

    @PutMapping(value = "/registrations/upDateRegistration")
    @ResponseStatus(HttpStatus.UPGRADE_REQUIRED)
    public ResponseEntity<Registration> updDateRegistration(@RequestBody Registration registration) {
        return ResponseEntity.status(HttpStatus.UPGRADE_REQUIRED).body(registrationService.upDateRegistration(registration));
    }

    @PostMapping("/registrations/register")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Registration> register(@RequestBody Registration registration) {
        return ResponseEntity.status(HttpStatus.CREATED).body(registrationService.register(registration));
    }

    @GetMapping( "/registrations/search")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List> search(@RequestBody Date dateFrom, Date dateTo, String descriptionFilter, String businessLocation) {
        return ResponseEntity.status(HttpStatus.CREATED).body(registrationService.search(dateFrom,dateTo,descriptionFilter,businessLocation));
    }

    @GetMapping(value = "/registrations/average")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List> average(@RequestBody Date dateFrom, Date dateTo) {
        return ResponseEntity.status(HttpStatus.CREATED).body(registrationService.average(dateFrom, dateTo));
    }
}
