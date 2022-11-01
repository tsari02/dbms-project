package com.dbms.project.model;

import lombok.Data;

import java.util.Date;

@Data
public class Transaction {
    private int TransactionId;
    private String BankBranch;
    private int ProductType;
    private int AccountNumber;
    private int amount;
    private String mode;
    private String VerificationStatus;
    private Date DateofTrans;
    private String BankName;
    public Object getMode() {
        return null;
    }
}
