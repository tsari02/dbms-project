package com.dbms.project.model;

import lombok.Data;

@Data
public class Feedback {
    private int id;
    private String reviews;
    private String complaints;
    private String suggestions;
    private int rating;
    private int customerOrderId; //FK    
}
