package com.dbms.project.model;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class LeavesAndSalaries {
    private int id;
    @NotNull
    @Min(0)
    private int leavesTaken;
    @NotNull
    @Min(0)
    private int leavesAllowed;
    @NotNull
    @Min(0)
    private int year; 
    @NotNull
    @Min(0)
    private int month;
    @NotNull
    @Min(0)
    private int overtime;
    @NotNull
    @Min(0)
    private int bonus;
    @NotNull
    @Min(0)
    private int penalty;
    @NotNull
    @Min(0)
    private int employeeId;
}
