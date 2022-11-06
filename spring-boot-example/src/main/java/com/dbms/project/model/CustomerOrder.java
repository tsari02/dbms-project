package com.dbms.project.model;

import lombok.Data;

import java.util.Date;
import java.lang.Boolean;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class CustomerOrder {
    private int id;
    @NotBlank
    private String deliveryAgentAssigned;
    @NotNull
    private Boolean verificationStatus;
    @NotNull
    private java.sql.Date deliveryDate;
    @NotNull
    private java.sql.Date orderedDate;
    @NotNull
    private int customerId;
    @NotNull
    private int employeeId;
}
