package com.dbms.project.model;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class Feedback {
    private int id;
    @NotBlank(message="Reviews cannot be blank")
    private String reviews;
    @NotBlank(message="Complaints cannot be blank")
    private String complaints;
    @NotBlank(message="Suggestions cannot be blank")
    private String suggestions;
    @Min(value=0, message="Rating must be between 0 and 10")
    @Max(value=10, message="Rating must be between 0 and 10")
    private int rating;
    private int customerOrderId; //FK    
}
