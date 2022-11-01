package com.dbms.project.model;

import lombok.Data;

@Data
public class ProductType {
    private int id;
    private String type;
    private String productImage;
    private int warrantyPeriod;
    private int quantity;
}
