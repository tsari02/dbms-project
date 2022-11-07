package com.dbms.project.model;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class LeavesAndSalaries {
    private int id;
    @Min(value=0, message="Leaves Taken should be positive")
    private int leavesTaken;
    @Min(value=0, message="Leaves Allowed should be positive")
    private int leavesAllowed;
    @Min(value=0, message="Year should be positive")
    private int year;
    @Min(value=1, message="Month must be between 1 and 12")
    @Max(value=12, message="Month must be between 1 and 12")
    private int month;
    @Min(value=0, message="Overtime should be positive")
    private int overtime;
    @Min(value=0, message="Bonus should be positive")
    private int bonus;
    @Min(value=0, message="Penalty should be positive")
    private int penalty;
    private int employeeId;
}
