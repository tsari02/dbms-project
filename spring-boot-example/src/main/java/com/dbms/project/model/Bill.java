package com.dbms.project.model;

import lombok.Data;

@Data
public class Bill {
    private int id;
    private String gstNumber;
    private int amount;
    private int discount;
    private int netAmount;
}
