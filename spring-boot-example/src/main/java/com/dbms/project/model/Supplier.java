package com.dbms.project.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class Supplier {
    private int id;
    @NotBlank
    private String firstName;
    private String middleName;
    private String lastName;
    @NotBlank
    private String contactNumber;
    @NotBlank
    private String street;
    @NotBlank
    private String city;
    @NotBlank
    private String state;
    @NotBlank
    private String postalCode;
    @NotBlank
    private String country;
}
