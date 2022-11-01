package com.dbms.project.model;


import lombok.Data;

import java.util.Date;

@Data
public class WorkExperience {
    private int id;
    private int employeeId;
    private String designation; 
    private Date joiningDate;
    private Date leavingDate;
}
