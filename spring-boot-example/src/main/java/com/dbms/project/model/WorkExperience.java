package com.dbms.project.model;


import lombok.Data;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class WorkExperience {
    private int id;
    private int employeeId;
    @Size(min=1, max=20, message="Length of Designation must be between 1 and 20 characters")
    @NotBlank(message="Designation cannot be blank")
    private String designation; 
    @NotNull(message="Date cannot be empty")
    private java.sql.Date joiningDate;
    @NotNull(message="Date cannot be empty")
    private java.sql.Date leavingDate;
}
