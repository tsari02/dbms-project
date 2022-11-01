package com.dbms.project.model;


import lombok.Data;

import java.util.Date;

import javax.validation.constraints.Email;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class Employee {
    private final int id;
    @NotBlank
    private String firstName;
    private String middleName;
    private String lastName;
    @NotBlank
    private String designation; 
    @NotNull
    private int salary;
    @NotBlank
    private String contactNumber;
    @NotNull
    private Date dateOfBirth;
    @NotBlank
    @Email
    private String emailId;
    @NotBlank
    private String city;
    @NotBlank
    private String state;
    @NotBlank
    private String postalCode;
    @NotBlank
    private String country;
    @NotBlank
    private String street;
}
