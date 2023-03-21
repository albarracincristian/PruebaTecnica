package com.cleverbusiness.cleverbusiness.models;

import jakarta.persistence.*;
import java.util.Date;

@Entity // La clase es una entidad JPA
@Table(name="Registration") // Se mapea a una tabla llamada "Registration"
public class Registration {
    @Id // Indica que el siguiente campo es la clave primaria de la entidad
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Indica que el valor de la clave primaria será generado automáticamente
    @Column(unique=true, nullable = false) // Indica que el campo es único y no puede ser nulo
    private Long Registration_Id; // El campo de la clave primaria

    @ManyToOne // Indica que se trata de una relación muchos-a-uno
    @JoinColumn(name = "employee_id",nullable = false) // Indica que el campo de la clave foránea es "employee_id" y no puede ser nulo
    private Employee employee; // El campo que referencia a la entidad "Employee"

    private Date date; // El campo de fecha
    private String registerType; // El campo de tipo de registro
    private String businessLocation; // El campo de ubicación de la empresa

    // Constructor que inicializa todos los campos
    public Registration(Long Registration_Id, Employee employee, Date date, String registerType, String businessLocation){
        this.Registration_Id=Registration_Id;
        this.employee=employee;
        this.date=date;
        this.registerType=registerType;
        this.businessLocation=businessLocation;
    }

    // Constructor vacío requerido por JPA
    public Registration() {

    }

    // Métodos getter y setter para cada campo
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
