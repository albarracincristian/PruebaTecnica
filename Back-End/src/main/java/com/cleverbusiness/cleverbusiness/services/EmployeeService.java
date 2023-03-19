
package com.cleverbusiness.cleverbusiness.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    public Employee getEmployee(Long idEmployee) {
        return employeeRepository.findById(idEmployee).orElse(null);
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee upDateEmployee(Employee upDateEmployee){
        Employee employee = employeeRepository.findById(upDateEmployee.getIdEmployee()).orElse(null);;
        if (employee ==  null){
            return null;
        }
        employee.setFirstName(upDateEmployee.getFirstName());
        employee.setLastName(upDateEmployee.getLastName());
        employee.setGender(upDateEmployee.getGender());
        return employeeRepository.save(employee);
    }

}
