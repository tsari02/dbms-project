package com.dbms.project.model;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class Bill {
    private int id;
    @NotBlank(message="GST Number cannot be blank")
    private String gstNumber;
    @Min(value=0,message="Amount must be positive")
    private int amount;
    @Min(value=0,message="Discount must be positive")
    private int discount;
    @Min(value=0,message="Net Amount must be positive")
    private int netAmount;
}
