package com.dbms.project.model;


import lombok.Data;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class WorkExperience {
    private int id;
    private int employeeId;
    @NotBlank(message="Designation cannot be blank")
    private String designation; 
    @NotNull(message="Date cannot be empty")
    private java.sql.Date joiningDate;
    @NotNull(message="Date cannot be empty")
    private java.sql.Date leavingDate;
}
