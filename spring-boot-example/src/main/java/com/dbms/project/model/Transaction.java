package com.dbms.project.model;

import lombok.Data;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class Transaction {
    private int id;
    @Size(min=1, max=25, message="Length of Bank Branch must be between 1 and 25 characters")
    @NotBlank(message="Bank Branch cannot be blank")
    private String bankBranch;
    @Size(min=1, max=25, message="Length of Account Number must be between 1 and 25 characters")
    @NotBlank(message="Account Number cannot be blank")
    private String accountNumber;
    @Min(value=0, message="Amount must be positive")
    private int amount;
    @Size(min=1, max=25, message="Length of Mode must be between 1 and 25 characters")
    @NotBlank(message="Mode cannot be blank")
    private String mode;
    @NotNull(message="Date cannot be empty")
    private java.sql.Date dateOfTransaction;
    @Size(min=1, max=25, message="Length of Bank Name must be between 1 and 25 characters")
    @NotBlank(message="Bank Name cannot be blank")
    private String bankName;
}
