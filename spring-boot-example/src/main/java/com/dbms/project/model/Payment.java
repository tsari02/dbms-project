package com.dbms.project.model;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class Payment {
    private int id;
    private int customerOrderId;
    private Integer transactionId;
    private int billId;
}
