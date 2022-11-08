package com.dbms.project.model;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class Bill {
    private int id;
    @Size(min=12, max=12, message="Length of GST Number must be 12 characters")
    @NotBlank(message="GST Number cannot be blank")
    private String gstNumber;
    @Min(value=0,message="Amount must be positive")
    private int amount;
    @Min(value=0,message="Discount must be positive")
    private int discount;
}
