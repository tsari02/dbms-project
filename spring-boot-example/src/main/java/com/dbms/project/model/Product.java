package com.dbms.project.model;

import lombok.Data;

@Data
public class Product {
    private int id;
    private String name;
    private int supplierOrderId;
    private int productTypeId;
    private int customerOrderId;
}
