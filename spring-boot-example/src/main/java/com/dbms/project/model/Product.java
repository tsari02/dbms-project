package com.dbms.project.model;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class Product {
    private int id;
    @NotNull
    private int supplierOrderId;
    @NotNull
    private int productTypeId;
    @NotNull
    private int customerOrderId;
}
