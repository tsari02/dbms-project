package com.dbms.project.model;

import lombok.Data;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class Transaction {
    private int id;
    @NotBlank
    private String bankBranch;
    @NotNull
    private int productType;
    @NotNull
    private int accountNumber;
    @NotNull
    @Min(0)
    private int amount;
    @NotBlank
    private String mode;
    @NotBlank
    private String verificationStatus;
    @NotNull
    private java.sql.Date dateOfTransaction;
    @NotBlank
    private String bankName;
}
