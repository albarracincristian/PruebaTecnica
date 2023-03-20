package com.cleverbusiness.cleverbusiness.repositories;

import com.cleverbusiness.cleverbusiness.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {


}