package com.dbms.project.model;

import lombok.Data;

import java.util.Date;
import java.lang.Boolean;

@Data
public class CustomerOrder {
    private int customerOrderId;
    private String deliveryAgentAssigned;
    private Boolean verificationStatus;
    private Date deliveryDate;
    private Date orderedDate;
    private int customerId;
    private int employeeId;
}
