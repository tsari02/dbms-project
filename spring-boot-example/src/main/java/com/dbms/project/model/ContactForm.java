package com.dbms.project.model;

import lombok.Data;

@Data
public class ContactForm {
    private int id;
    private String emailId;
    private String name;
    private String contactNumber;
    private String reply;
    private String query;
    private int customerId;
}
