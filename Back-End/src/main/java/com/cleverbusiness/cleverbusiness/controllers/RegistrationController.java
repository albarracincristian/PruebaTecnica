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

    // Obtener todos los registros
    @GetMapping("/registrations/registersList")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(registrationService.getAll());
    }

    // Obtener un registro específico por ID
    @GetMapping("/registrations/{idRegistration}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Registration> getRegistration(@PathVariable Long idRegistration) {
        return ResponseEntity.status(HttpStatus.OK).body(registrationService.getRegistration(idRegistration));
    }

    // Actualizar un registro existente
    @PutMapping(value = "/registrations/upDateRegistration")
    @ResponseStatus(HttpStatus.UPGRADE_REQUIRED)
    public ResponseEntity<Registration> updDateRegistration(@RequestBody Registration registration) {
        return ResponseEntity.status(HttpStatus.UPGRADE_REQUIRED).body(registrationService.upDateRegistration(registration));
    }

    // Registrar un nuevo registro
    @PostMapping("/registrations/register")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Registration> register(@RequestBody Registration registration) {
        return ResponseEntity.status(HttpStatus.CREATED).body(registrationService.register(registration));
    }

    // Buscar registros por fecha, filtro de descripción y ubicación del negocio
    @GetMapping("/registrations/search")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Object[]>> search(
            @RequestParam("dateFrom") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateFrom,
            @RequestParam("dateTo") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateTo,
            @RequestParam("descriptionFilter") String descriptionFilter,
            @RequestParam("businessLocation") String businessLocation) {
        List<Object[]> results = registrationService.search(dateFrom, dateTo, descriptionFilter, businessLocation);
        return ResponseEntity.ok(results);
    }

    // Obtener el promedio de registros por fecha
   @GetMapping(value = "/registrations/average")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List> average(@RequestParam("dateFrom") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateFrom,
                                        @RequestParam("dateTo") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateTo) {
        return ResponseEntity.status(HttpStatus.OK).body(registrationService.average(dateFrom, dateTo));
    }
}