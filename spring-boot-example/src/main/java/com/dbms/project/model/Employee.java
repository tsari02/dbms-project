package com.dbms.project.model;


import lombok.Data;

import java.util.Date;

@Data
public class Employee {
    private int id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String designation; 
    private int salary;
    private String contactNumber;
    private Date dateOfBirth;
    private String emailId;
    private String city;
    private String state;
    private String postalCode;
    private String country;
    private String street;
}
