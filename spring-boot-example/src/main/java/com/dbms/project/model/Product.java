package com.dbms.project.model;

import lombok.Data;

@Data
public class Product {
    private int id;
    private int supplierOrderId;
    private int productTypeId;
    private int customerOrderId;
}
