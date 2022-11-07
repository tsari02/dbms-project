package com.dbms.project.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class Supplier {
    private int id;
    @NotBlank(message="First Name cannot be blank")
    private String firstName;
    private String middleName;
    private String lastName;
    @NotBlank(message="Contact Number cannot be blank")
    private String contactNumber;
    @NotBlank(message="Street address cannot be blank")
    private String street;
    @NotBlank(message="City cannot be blank")
    private String city;
    @NotBlank(message="State cannot be blank")
    private String state;
    @NotBlank(message="Postal Code cannot be blank")
    private String postalCode;
    @NotBlank(message="Country cannot be blank")
    private String country;
}
