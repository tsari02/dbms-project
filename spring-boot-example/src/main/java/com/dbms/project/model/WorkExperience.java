package com.dbms.project.model;


import lombok.Data;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class WorkExperience {
    private int id;
    @NotBlank
    private int employeeId;
    @NotBlank
    private String designation; 
    @NotNull
    private java.sql.Date joiningDate;
    @NotNull
    private java.sql.Date leavingDate;
}
