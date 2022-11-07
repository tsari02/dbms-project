package com.dbms.project.model;

import lombok.Data;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class SupplierOrder {
    private int id;
    @NotNull(message="Date cannot be empty")
    private java.sql.Date dateOfOrder;
    @NotBlank(message="Status cannot be blank")
    private String status;
    private int supplierId;
}
