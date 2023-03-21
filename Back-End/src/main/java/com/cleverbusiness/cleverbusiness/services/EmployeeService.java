package com.cleverbusiness.cleverbusiness.services;

import com.cleverbusiness.cleverbusiness.models.Employee;
import com.cleverbusiness.cleverbusiness.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    // Retorna una lista con todos los empleados.
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    // Retorna un empleado por su id.
    public Employee getEmployee(Long Employee_Id) {
        return employeeRepository.findById(Employee_Id).orElse(null);
    }

    // Guarda un empleado en la base de datos.
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // Actualiza los datos de un empleado existente.
    public Employee upDateEmployee(Employee upDateEmployee){
        Employee employee = employeeRepository.findById(upDateEmployee.getEmployee_Id()).orElse(null);
        if (employee ==  null){
            return null;
        }
        employee.setfirst_name(upDateEmployee.getfirst_name());
        employee.setlast_name(upDateEmployee.getlast_name());
        employee.setGender(upDateEmployee.getGender());
        return employeeRepository.save(employee);
    }

}
