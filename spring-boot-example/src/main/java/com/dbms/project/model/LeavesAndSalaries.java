package com.dbms.project.model;

import lombok.Data;

@Data
public class LeavesAndSalaries {
    private int id;
    private int leavesTaken;
    private int leavesAllowed;
    private int year; 
    private int month;
    private int overtime;
    private int bonus;
    private int penalty;
    private int employeeId;
}
