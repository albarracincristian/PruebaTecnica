package com.cleverbusiness.cleverbusiness.repositories;

import com.cleverbusiness.cleverbusiness.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Indica que esta interfaz es un repositorio JPA
public interface EmployeeRepository extends JpaRepository<Employee,Long> { // Extiende de JpaRepository para obtener métodos CRUD para la entidad "Employee"

}
