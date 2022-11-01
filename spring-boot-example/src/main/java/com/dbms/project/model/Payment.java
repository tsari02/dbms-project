package com.dbms.project.model;

import lombok.Data;

@Data
public class Payment {
    private int id;
    private int customerOrderId;
    private int transactionId;
    private int billId;
}
