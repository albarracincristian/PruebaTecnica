package com.cleverbusiness.cleverbusiness.models;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name="Registration")
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique=true, nullable = false)
    private Long Registration_Id;

    @ManyToOne
    @JoinColumn(name = "employee_id",nullable = false)
    private Employee employee;

    private Date date;
    private String registerType;
    private String businessLocation;

    public Registration(Long Registration_Id, Employee employee, Date date, String registerType, String businessLocation){
        this.Registration_Id=Registration_Id;
        this.employee=employee;
        this.date=date;
        this.registerType=registerType;
        this.businessLocation=businessLocation;
    }

    public Registration() {

    }

    public Long getRegistration_Id() {
        return Registration_Id;
    }

    public void setRegistration_Id(Long Registration_Id) {
        this.Registration_Id = Registration_Id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getRegisterType() {
        return registerType;
    }

    public void setRegisterType(String registerType) {
        this.registerType = registerType;
    }

    public String getBusinessLocation() {
        return businessLocation;
    }

    public void setBusinessLocation(String businessLocation) {
        this.businessLocation = businessLocation;
    }
}