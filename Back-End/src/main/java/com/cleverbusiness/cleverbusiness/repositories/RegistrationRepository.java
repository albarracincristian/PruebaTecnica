package com.cleverbusiness.cleverbusiness.repositories;

import com.cleverbusiness.cleverbusiness.models.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {

    @Query(value = "SELECT Employee.first_name, Employee.last_name, " +
            "sum(CASE WHEN register_type = 'ingreso' THEN 1 ELSE 0 END) AS conteo_ingreso, " +
            "sum(CASE WHEN register_type = 'egreso' THEN 1 ELSE 0 END) AS conteo_egreso " +
            "FROM Registration " +
            "INNER JOIN Employee ON Registration.employee_id = Employee.employee_id " +
            "WHERE Registration.date >= :dateFrom AND Registration.date <= :dateTo AND Registration.business_location = :businessLocation " +
            "AND (Employee.first_name LIKE %:descriptionFilter% OR Employee.last_name LIKE %:descriptionFilter%) " +
            "GROUP BY Employee.first_name, Employee.last_name", nativeQuery = true)
    List<Object[]> searchByDescriptionAndLocation(@Param("dateFrom") Date dateFrom,
                                                   @Param("dateTo") Date dateTo,
                                                   @Param("descriptionFilter") String descriptionFilter,
                                                   @Param("businessLocation") String businessLocation);

    @Query(value = "SELECT Employee.first_name, Employee.last_name, " +
            "sum(CASE WHEN register_type = 'ingreso' THEN 1 ELSE 0 END) AS conteo_ingreso, " +
            "sum(CASE WHEN register_type = 'egreso' THEN 1 ELSE 0 END) AS conteo_egreso " +
            "FROM Registration " +
            "INNER JOIN Employee ON Registration.employee_id = Employee.employee_id " +
            "WHERE Registration.date >= :dateFrom AND Registration.date <= :dateTo AND Registration.business_location = :businessLocation " +
            "GROUP BY Employee.first_name, Employee.last_name", nativeQuery = true)
    List<Object[]> searchByLocation(@Param("dateFrom") Date dateFrom,
                                     @Param("dateTo") Date dateTo,
                                     @Param("businessLocation") String businessLocation);
    
    // Consulta para obtener la ubicación del negocio, el tipo de registro, el promedio de mujeres y hombres para cada tipo de registro
    @Query(value = "SELECT Registration.business_location, Registration.register_type, " +
            "avg(CASE WHEN Employee.gender = 'femenino' THEN 1.0 ELSE 0.0 END) AS promedio_mujeres, " +
            "avg(CASE WHEN Employee.gender = 'masculino' THEN 1.0 ELSE 0.0 END) AS promedio_hombres " +
            "FROM Employee " +
            "INNER JOIN Registration ON Employee.employee_id = Registration.employee_id " +
            "WHERE Registration.date >= :dateFrom AND Registration.date <= :dateTo " +
            "GROUP BY Registration.business_location, Registration.register_type", nativeQuery = true)
    List<Object[]> average(@Param("dateFrom") Date dateFrom, @Param("dateTo") Date dateTo);
}
