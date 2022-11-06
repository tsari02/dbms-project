package com.dbms.project.model;

import lombok.Data;

import java.util.Date;
import java.lang.Boolean;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Data
public class CustomerOrder {
    private int id;
    @NotBlank
    private String deliveryAgentAssigned;
    @NotNull
    private Boolean verificationStatus;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private java.sql.Date deliveryDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private java.sql.Date orderedDate;
    @NotNull
    private int customerId;
    @NotNull
    private int employeeId;
}
