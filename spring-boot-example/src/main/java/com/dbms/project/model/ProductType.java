package com.dbms.project.model;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class ProductType {
    private int id;
    @Size(min=1, max=25, message="Length of Name must be between 1 and 25 characters")
    @NotBlank(message="Name cannot be blank")
    private String name;
    @Size(min=1, max=255, message="Length of Product Image must be between 1 and 255 characters")
    @NotBlank(message="Product Image cannot be blank")
    private String productImage;
    private int warrantyPeriod;
    private int quantity;
}
