package com.cleverbusiness.cleverbusiness.controllers;

import com.cleverbusiness.cleverbusiness.models.Registration;
import com.cleverbusiness.cleverbusiness.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

@RestController
public class RegistrationController {
    @Autowired
    RegistrationService registrationService;

    @GetMapping("/registrations/registersList")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(registrationService.getAll());
    }

    @GetMapping("/registrations/{idRegistration}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Registration> getRegistration(@PathVariable Long idRegistration) {
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

@GetMapping("/registrations/search")
@ResponseStatus(HttpStatus.OK)
public ResponseEntity<List<Object>> search(
    @RequestParam("dateFrom") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateFrom,
    @RequestParam("dateTo") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateTo,
    @RequestParam("descriptionFilter") String descriptionFilter,
    @RequestParam("businessLocation") String businessLocation) {
    
    List<Object> results = registrationService.search(dateFrom, dateTo, descriptionFilter, businessLocation);
    return ResponseEntity.ok(results);
}

    @GetMapping(value = "/registrations/average")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List> average(@RequestBody Date dateFrom, Date dateTo) {
        return ResponseEntity.status(HttpStatus.CREATED).body(registrationService.average(dateFrom, dateTo));
    }
}