package com.dbms.project.model;

import lombok.Data;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class SupplierOrder {
    private int id;
    @NotNull(message="Date cannot be empty")
    private java.sql.Date dateOfOrder;
    @Size(min=1, max=20, message="Length of Status must be between 1 and 20 characters")
    @NotBlank(message="Status cannot be blank")
    private String status;
    private int supplierId;
}
