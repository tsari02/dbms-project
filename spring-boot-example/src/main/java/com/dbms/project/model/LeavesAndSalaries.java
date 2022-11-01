package com.dbms.project.model;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class LeavesAndSalaries {
    private int id;
    @NotNull
    private int leavesTaken;
    @NotNull
    private int leavesAllowed;
    @NotNull
    private int year; 
    @NotNull
    private int month;
    @NotNull
    private int overtime;
    @NotNull
    private int bonus;
    @NotNull
    private int penalty;
    @NotNull
    private int employeeId;
}
