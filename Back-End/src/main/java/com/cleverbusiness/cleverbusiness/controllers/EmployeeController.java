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

    // Inyección de dependencia del servicio de Employee
    @Autowired
    EmployeeService employeeService;

    // Obtener una lista de todos los empleados
    @GetMapping("/employees/employeeList")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getAll());
    }

    // Obtener un solo empleado por su ID
    @GetMapping("/employees/{employeeId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Employee> getEmployee(@PathVariable Long employeeId) {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getEmployee(employeeId));
    }

    // Guardar un nuevo empleado
    @PostMapping("/employees/save")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.saveEmployee(employee));
    }

    // Actualizar un empleado existente
    @PutMapping("/employees/upDateEmployee")
    @ResponseStatus(HttpStatus.UPGRADE_REQUIRED)
    public ResponseEntity<Employee> updDateEmployee(@RequestBody Employee employee) {
        return ResponseEntity.status(HttpStatus.UPGRADE_REQUIRED).body(employeeService.upDateEmployee(employee));
    }
}
