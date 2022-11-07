package com.dbms.project.model;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class Customer {
    private int id;
    @NotBlank(message="First Name cannot be blank")
    private String firstName;
    private String middleName;
    private String lastName;
    @NotBlank(message="Contact Number cannot be blank")
    private String contactNumber;
    @NotNull(message="Date cannot be empty")
    private java.sql.Date dateOfBirth;
    @Email(message="Email id must be valid")
    @NotBlank(message="Email id cannot be blank")
    private String emailId;
    @NotBlank(message = "City cannot be blank")
    private String city;
    @NotBlank(message = "State cannot be blank")
    private String state;
    @NotBlank(message = "Postal code cannot be blank")
    private String postalCode;
    @NotBlank(message = "Country cannot be blank")
    private String country;
    @NotBlank(message = "Street address cannot be blank")
    private String street;
}
