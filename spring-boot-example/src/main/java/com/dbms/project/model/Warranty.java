package com.dbms.project.model;

import lombok.Data;

import java.util.Date;

@Data
public class Warranty {
    private int id;
    private String coverage;
    private int productId ; //FK
    private int customerId; //FK
    private Date endDate;
}
