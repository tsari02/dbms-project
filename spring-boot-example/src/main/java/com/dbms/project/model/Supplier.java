package com.dbms.project.model;

import lombok.Data;

@Data
public class Supplier {
    private int id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String contactNumber;
    private String street;
    private String city;
    private String state;
    private String postalCode;
    private String country;
}
