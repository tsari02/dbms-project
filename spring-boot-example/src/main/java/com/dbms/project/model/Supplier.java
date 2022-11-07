package com.dbms.project.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class Supplier {
    private int id;
    @Size(min=1, max=25, message="Length of First Name must be between 1 and 25 characters")
    @NotBlank(message="First Name cannot be blank")
    private String firstName;
    @Size(min=1, max=50, message="Length of Middle Name must be between 1 and 50 characters")
    private String middleName;
    @Size(min=1, max=25, message="Length of Last Name must be between 1 and 25 characters")
    private String lastName;
    @Size(min=1, max=20, message="Length of Contact Number must be between 1 and 20 characters")
    @NotBlank(message="Contact Number cannot be blank")
    private String contactNumber;
    @Size(min=1, max=50, message="Length of Street Address must be between 1 and 50 characters")
    @NotBlank(message="Street address cannot be blank")
    private String street;
    @Size(min=1, max=50, message="Length of City must be between 1 and 50 characters")
    @NotBlank(message="City cannot be blank")
    private String city;
    @Size(min=1, max=50, message="Length of State must be between 1 and 50 characters")
    @NotBlank(message="State cannot be blank")
    private String state;
    @Size(min=1, max=10, message="Length of Postal Code must be between 1 and 10 characters")
    @NotBlank(message="Postal Code cannot be blank")
    private String postalCode;
    @Size(min=1, max=50, message="Length of Country must be between 1 and 50 characters")
    @NotBlank(message="Country cannot be blank")
    private String country;
}
