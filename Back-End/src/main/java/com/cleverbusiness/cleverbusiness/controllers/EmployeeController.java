package com.cleverbusiness.cleverbusiness.controllers;

import com.cleverbusiness.cleverbusiness.models.Employee;
import com.cleverbusiness.cleverbusiness.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees/employeeList")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getAll());
    }

    @GetMapping( "/employees/getEmployee")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Employee> getEmployee(@RequestBody Long Employee_Id) {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getEmployee(Employee_Id));
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