package com.dbms.project.model;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class OrderedProductType {
    private int id;
    @NotNull
    private int supplierOrderId;
    @NotNull
    @Min(0)
    private int quantity;
    @NotNull
    private int productTypeId;
    @NotNull
    private int numberDelivered;
}
