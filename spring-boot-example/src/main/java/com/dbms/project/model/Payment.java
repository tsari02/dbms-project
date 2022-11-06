package com.dbms.project.model;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class Payment {
    private int id;
    @NotNull
    private int customerOrderId;
    @NotNull
    private int transactionId;
    @NotNull
    private int billId;
}
