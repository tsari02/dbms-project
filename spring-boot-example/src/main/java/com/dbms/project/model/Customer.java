package com.dbms.project.model;

import lombok.Data;

import javax.validation.constraints.*;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class Customer {
    private int id;
    @Size(min=1, max=25, message="Length of First Name must be between 1 and 25 characters")
    @NotBlank(message = "First name is mandatory")
    private String firstName = null;
    @Size(min=1, max=50, message="Length of Middle Name must be between 1 and 50 characters")
    private String middleName;
    @Size(min=1, max=25, message="Length of Last Name must be between 1 and 25 characters")
    private String lastName;
    @NotBlank(message="Designation cannot be blank")
    private String designation;
    @NotNull(message="Salary cannot be empty")
    @Min(value = 0, message = "Salary must be positive")
    private int salary;
    @Size(min=1, max=20, message="Length of Contact Number must be between 1 and 20 characters")
    @NotBlank(message="Contact number cannot be blank")
    private String contactNumber;
    @NotNull(message = "Date cannot be empty")
    private java.sql.Date dateOfBirth;
    @Size(min=1, max=255, message="Length of Email Address must be between 1 and 255 characters")
    @NotBlank(message="Email id cannot be blank")
    @Email(message="Email id must be valid")
    private String emailId;
    @Size(min=1, max=50, message="Length of City must be between 1 and 50 characters")
    @NotBlank(message = "City cannot be blank")
    private String city;
    @Size(min=1, max=50, message="Length of State must be between 1 and 50 characters")
    @NotBlank(message = "State cannot be blank")
    private String state;
    @Size(min=1, max=10, message="Length of Postal Code must be between 1 and 10 characters")
    @NotBlank(message = "Postal code cannot be blank")
    private String postalCode;
    @Size(min=1, max=50, message="Length of Country must be between 1 and 50 characters")
    @NotBlank(message = "Country cannot be blank")
    private String country;
    @Size(min=1, max=50, message="Length of Street Address must be between 1 and 50 characters")
    @NotBlank(message = "Street address cannot be blank")
    private String street;
}
