package com.dbms.project.model;

import lombok.Data;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class Transaction {
    private int id;
    @NotBlank(message="Bank Branch cannot be blank")
    private String bankBranch;
    private int productType;
    private int accountNumber;
    @Min(value=0, message="Amount must be positive")
    private int amount;
    @NotBlank(message="Mode cannot be blank")
    private String mode;
    @NotBlank(message="Verification Status cannot be blank")
    private String verificationStatus;
    @NotNull(message="Date cannot be empty")
    private java.sql.Date dateOfTransaction;
    @NotBlank(message="Bank Name cannot be blank")
    private String bankName;
}
