package com.dbms.project.model;

import lombok.Data;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class Warranty {
    private int id;
    @NotBlank
    private String coverage;
    @NotNull
    private int productId ; //FK
    @NotNull
    private int customerId; //FK
    @NotNull
    private Date endDate;
}
