package com.dbms.project.model;

import lombok.Data;

import java.util.Date;
import java.lang.Boolean;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Data
public class CustomerOrder {
    private int id;
    private Boolean deliveryAgentAssigned;
    private Boolean verificationStatus;
    private java.sql.Date deliveryDate;
    @NotNull(message = "Date cannot be empty")
    private java.sql.Date orderedDate;
    private int customerId;
    private int employeeId;
    private Boolean orderCompleted;
    private Boolean paymentCompleted;
}
