package com.dbms.project.model;

import lombok.Data;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class SupplierOrder {
    private int id;
    @NotNull
    private java.sql.Date dateOfOrder;
    @NotBlank
    private String status;
    private int supplierId;
}
