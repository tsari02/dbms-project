package com.dbms.project.model;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ProductType {
    private int id;
    @NotBlank(message="Name cannot be blank")
    private String name;
    @NotBlank(message="Product Image cannot be blank")
    private String productImage;
    private int warrantyPeriod;
    private int quantity;
}
