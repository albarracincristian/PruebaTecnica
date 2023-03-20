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

    public List<Registration> getAll() {
        return registrationRepository.findAll();
    }

    public Registration getRegistration(Long idRegistration) {
        return registrationRepository.findById(idRegistration).orElse(null);
    }

    public Registration upDateRegistration(Registration upDateRegistration){
        Registration registration = registrationRepository.findById(upDateRegistration.getIdRegistration()).orElse(null);;
        if (registration ==  null){
            return null;
        }
        registration.setEmployee(upDateRegistration.getEmployee());
        registration.setDate(upDateRegistration.getDate());
        registration.setRegisterType(upDateRegistration.getRegisterType());
        registration.setBusinessLocation(upDateRegistration.getBusinessLocation());
        return registrationRepository.save(registration);
    }

    public Registration register(Registration registration){
        return registrationRepository.saveAndFlush(registration);
    }

    public List<Object> search (Date dateFrom, Date dateTo, String descriptionFilter, String businessLocation){
        if(descriptionFilter.equals("nombre")){
            return registrationRepository.searchFirstName(businessLocation,dateFrom,dateTo);
        }
        else{
            return registrationRepository.searchLastName(businessLocation,dateFrom,dateTo);
        }
    }

    public List<Object> average(Date dateFrom, Date dateTo){
        return registrationRepository.average(dateFrom,dateTo);
    }
}