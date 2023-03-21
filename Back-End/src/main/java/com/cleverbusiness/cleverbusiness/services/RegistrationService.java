package com.cleverbusiness.cleverbusiness.services;

import com.cleverbusiness.cleverbusiness.models.Registration;
import com.cleverbusiness.cleverbusiness.repositories.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RegistrationService {
    @Autowired
    RegistrationRepository registrationRepository;

    // Método que retorna una lista con todos los registros
    public List<Registration> getAll() {
        return registrationRepository.findAll();
    }

    // Método que retorna un registro específico según el id
    public Registration getRegistration(Long idRegistration) {
        return registrationRepository.findById(idRegistration).orElse(null);
    }

    // Método que actualiza un registro según el objeto pasado como parámetro
    public Registration upDateRegistration(Registration upDateRegistration){
        Registration registration = registrationRepository.findById(upDateRegistration.getRegistration_Id()).orElse(null);
        if (registration ==  null){
            return null;
        }
        registration.setEmployee(upDateRegistration.getEmployee());
        registration.setDate(upDateRegistration.getDate());
        registration.setRegisterType(upDateRegistration.getRegisterType());
        registration.setBusinessLocation(upDateRegistration.getBusinessLocation());
        return registrationRepository.save(registration);
    }

    // Método que registra un nuevo registro
    public Registration register(Registration registration){
        return registrationRepository.saveAndFlush(registration);
    }

    // Método que realiza una búsqueda según un rango de fechas, un filtro de descripción y una ubicación de negocio
   public List<Object[]> search(Date dateFrom, Date dateTo, String descriptionFilter, String businessLocation) {
        if (descriptionFilter == null || descriptionFilter.isEmpty()) {
            return registrationRepository.searchByLocation(dateFrom, dateTo, businessLocation);
        } else {
            return registrationRepository.searchByDescriptionAndLocation(dateFrom, dateTo, descriptionFilter, businessLocation);
        }
    }

    // Método que retorna la lista de promedios de horas de trabajo en un rango de fechas
    public List<Object[]> average(Date dateFrom, Date dateTo){
        return registrationRepository.average(dateFrom,dateTo);
    }
}
