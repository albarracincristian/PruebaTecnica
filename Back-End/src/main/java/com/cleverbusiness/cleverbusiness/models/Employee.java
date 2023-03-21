package com.cleverbusiness.cleverbusiness.models;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity // La clase es una entidad JPA
@Table(name="Employee") // Se mapea a una tabla llamada "Employee"
public class Employee {
    @Id // Indica que el siguiente campo es la clave primaria de la entidad
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Indica que el valor de la clave primaria será generado automáticamente
    @Column(unique=true, nullable = false) // Indica que el campo es único y no puede ser nulo
    private Long Employee_Id; // El campo de la clave primaria

    @JsonProperty("first_name")
    private String first_name;
    @JsonProperty("last_name")
    private String last_name;
    private String gender;

    // Constructor que acepta parámetros
    public Employee(Long Employee_Id, String first_name, String last_name, String gender){
        this.Employee_Id=Employee_Id;
        this.first_name=first_name;
        this.last_name=last_name;
        this.gender=gender;
    }

    // Constructor vacío
    public Employee() {

    }

    // Método getter para Employee_Id
    public Long getEmployee_Id (){
        return Employee_Id;
    }

    // Método setter para Employee_Id
    public void setEmployee_Id (Long Employee_Id){
        this.Employee_Id=Employee_Id;
    }

    // Método getter para first_name
    public String getfirst_name(){
        return first_name;
    }

    // Método setter para first_name
    public void setfirst_name(String first_name){
        this.first_name=first_name;
    }

    // Método getter para last_name
    public String getlast_name(){
        return last_name;
    }

    // Método setter para last_name
    public void setlast_name(String last_name){
        this.last_name=last_name;
    }

    // Método getter para gender
    public String getGender(){
        return gender;
    }

    // Método setter para gender
    public void setGender(String gender){
        this.gender=gender;
    }

}
