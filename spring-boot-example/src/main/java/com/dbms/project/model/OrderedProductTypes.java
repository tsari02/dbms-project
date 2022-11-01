package com.dbms.project.model;

import lombok.Data;
import javax.validation.constraints.NotNull;

@Data
public class OrderedProductTypes {
    private int id;
    @NotNull
    private int supplierOrderId;
    @NotNull
    private int quantity; 
    @NotNull
    private int productTypeId;
    @NotNull
    private int numberDelivered;
}