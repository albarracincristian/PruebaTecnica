package com.cleverbusiness.cleverbusiness.models;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="Employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique=true, nullable = false)
    private Long idEmployee;

    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    private String gender;

    public Employee(Long idEmployee, String firstName, String lastName, String gender){
        this.idEmployee=idEmployee;
        this.firstName=firstName;
        this.lastName=lastName;
        this.gender=gender;
    }

    public Employee() {

    }

    public Long getIdEmployee (){
        return idEmployee;
    }

    public void setIdEmployee(Long idEmployee){
        this.idEmployee=idEmployee;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String firstName){
        this.firstName=firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public void setLastName(String lastName){
        this.lastName=lastName;
    }

    public String getGender(){
        return gender;
    }

    public void setGender(String gender){
        this.gender=gender;
    }

}