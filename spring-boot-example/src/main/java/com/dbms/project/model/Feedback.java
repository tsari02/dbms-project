package com.dbms.project.model;

import lombok.Data;

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
    private int rating;
    @NotNull
    private int customerOrderId; //FK    
}
