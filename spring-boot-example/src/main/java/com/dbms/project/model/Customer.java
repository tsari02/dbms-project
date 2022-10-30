package com.dbms.project.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class Customer {
    private int id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String contactNumber;
    private Date dateOfBirth;
    private String emailId;
    private String city;
    private String state;
    private String postalCode;
    private String country;
    private String street;
}
