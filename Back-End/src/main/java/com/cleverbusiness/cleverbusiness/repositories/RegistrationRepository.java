package com.cleverbusiness.cleverbusiness.repositories;

import com.cleverbusiness.cleverbusiness.models.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {

    @Query(value = "SELECT Employee.first_name, " +
            "sum(CASE WHEN register_type = 'ingreso' THEN 1 ELSE 0 END) AS conteo_ingreso, " +
            "sum(CASE WHEN register_type = 'egreso' THEN 1 ELSE 0 END) AS conteo_egreso " +
            "FROM Registration WHERE Registration.date >= :dateFrom AND Registration.date <= :dateTo AND Registration.business_location = :businessLocation " +
            "GROUP BY Employee.first_name;", nativeQuery = true)
    List<Object> searchFirstName(@Param("businessLocation") String businessLocation, @Param("dateFrom") Date dateFrom, @Param("dateTo") Date dateTo);

    @Query(value = "SELECT Employee.last_name, " +
            "sum(CASE WHEN register_type = 'ingreso' THEN 1 ELSE 0 END) AS conteo_ingreso, " +
            "sum(CASE WHEN register_type = 'egreso' THEN 1 ELSE 0 END) AS conteo_egreso " +
            "FROM Registration WHERE Registration.date >= :dateFrom AND Registration.date <= :dateTo AND Registration.business_location = :businessLocation " +
            "GROUP BY Employee.last_name;", nativeQuery = true)
    List<Object> searchLastName(@Param("businessLocation") String businessLocation, @Param("dateFrom") Date dateFrom, @Param("dateTo") Date dateTo);


       
    @Query(value = "SELECT Registration.business_location, Registration.register_type, " +
            "avg(CASE WHEN Employee.gender = 'femenino' THEN 1.0 ELSE 0.0 END) AS promedio_mujeres, " +
            "avg(CASE WHEN Employee.gender = 'masculino' THEN 1.0 ELSE 0.0 END) AS promedio_hombres " +
            "FROM Employee " +
            "INNER JOIN Registration ON Employee.employee_id = Registration.employee_id " +
            "WHERE Registration.date >= :dateFrom AND Registration.date <= :dateTo " +
            "GROUP BY Registration.business_location, Registration.register_type", nativeQuery = true)
    List<Object> average(@Param("dateFrom") Date dateFrom, @Param("dateTo") Date dateTo);

}
