package com.dbms.project.model;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class Bill {
    private int id;
    @NotBlank
    private String gstNumber;
    @NotNull
    @Min(0)
    private int amount;
    @NotNull
    @Min(0)
    private int discount;
    @NotNull
    @Min(0)
    private int netAmount;
}
