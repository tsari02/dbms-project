package com.dbms.project.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class Bill {
    private int id;
    @NotBlank
    private String gstNumber;
    @NotNull
    private int amount;
    @NotNull
    private int discount;
    @NotNull
    private int netAmount;
}
