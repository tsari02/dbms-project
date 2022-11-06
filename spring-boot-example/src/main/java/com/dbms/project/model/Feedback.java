package com.dbms.project.model;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class Feedback {
    private int id;
    @NotBlank
    private String reviews;
    @NotBlank
    private String complaints;
    @NotBlank
    private String suggestions;
    @NotNull
    @Min(0)
    @Max(10)
    private int rating;
    @NotNull
    private int customerOrderId; //FK    
}
