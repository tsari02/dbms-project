package com.dbms.project.model;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class Customer {
    private int id;
    @NotBlank
    private String firstName;
    private String middleName;
    private String lastName;
    @NotBlank
    private String contactNumber;
    @NotNull
    private Date dateOfBirth;
    @Email
    @NotBlank
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
