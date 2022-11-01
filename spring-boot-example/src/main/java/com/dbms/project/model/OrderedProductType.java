package com.dbms.project.model;

import lombok.Data;

@Data
public class OrderedProductType {
    private int id;
    private int supplierOrderId;
    private int quantity;
    private int productTypeId;
    private int numberDelivered;
}
