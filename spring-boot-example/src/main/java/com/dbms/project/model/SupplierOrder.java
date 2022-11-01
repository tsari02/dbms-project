package com.dbms.project.model;

import lombok.Data;

import java.util.Date;

@Data
public class SupplierOrder {
    private int id;
    private Date dateOfOrder;
    private String status;
    private int supplierId;
}
