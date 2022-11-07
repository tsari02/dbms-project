package com.dbms.project.model;

import lombok.Data;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class Warranty {
    private int id;
    @NotBlank(message="Coverage cannot be blank")
    private String coverage;
    private int productId ; //FK
    private int customerId; //FK
    @NotNull(message="Date cannot be empty")
    private java.sql.Date endDate;
}
