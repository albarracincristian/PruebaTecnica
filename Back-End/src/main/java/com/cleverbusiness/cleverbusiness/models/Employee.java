package com.cleverbusiness.cleverbusiness.models;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="Employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique=true, nullable = false)
    private Long Employee_Id;

    @JsonProperty("first_name")
    private String first_name;
    @JsonProperty("last_name")
    private String last_name;
    private String gender;

    public Employee(Long Employee_Id, String first_name, String last_name, String gender){
        this.Employee_Id=Employee_Id;
        this.first_name=first_name;
        this.last_name=last_name;
        this.gender=gender;
    }

    public Employee() {

    }

    public Long getEmployee_Id (){
        return Employee_Id;
    }

    public void setEmployee_Id (Long Employee_Id){
        this.Employee_Id=Employee_Id;
    }

    public String getfirst_name(){
        return first_name;
    }

    public void setfirst_name(String first_name){
        this.first_name=first_name;
    }

    public String getlast_name(){
        return last_name;
    }

    public void setlast_name(String last_name){
        this.last_name=last_name;
    }

    public String getGender(){
        return gender;
    }

    public void setGender(String gender){
        this.gender=gender;
    }

}