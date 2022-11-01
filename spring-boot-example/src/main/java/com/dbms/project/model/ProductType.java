package com.dbms.project.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ProductType {
    private int id;
    @NotBlank
    private String type;
    @NotBlank
    private String productImage;
    @NotNull
    private int warrantyPeriod;
    @NotNull
    private int quantity;
}
