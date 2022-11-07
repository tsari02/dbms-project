package com.dbms.project.model;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class OrderedProductType {
    private int id;
    private int supplierOrderId;
    @Min(value=0,message="Quantity must be positive")
    private int quantity;
    private int productTypeId;
    private int numberDelivered;
}
