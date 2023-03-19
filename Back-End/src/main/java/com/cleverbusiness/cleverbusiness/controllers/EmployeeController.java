package com.cleverbusiness.cleverbusiness.controllers;

import com.cleverbusiness.cleverbusiness.models.Employee;
import com.cleverbusiness.cleverbusiness.services.EmployeeService;
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

public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees/employessList")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getAll());
    }

    @GetMapping( "/employees/getEmployee")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Employee> getEmployee(@RequestBody Long idEmployee) {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getEmployee(idEmployee));
    }

    @PostMapping("/employees/save")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.saveEmployee(employee));
    }

    @PutMapping("/employees/upDateEmployee")
    @ResponseStatus(HttpStatus.UPGRADE_REQUIRED)
    public ResponseEntity<Employee> updDateEmployee(@RequestBody Employee employee) {
        return ResponseEntity.status(HttpStatus.UPGRADE_REQUIRED).body(employeeService.upDateEmployee(employee));
    }    
}
