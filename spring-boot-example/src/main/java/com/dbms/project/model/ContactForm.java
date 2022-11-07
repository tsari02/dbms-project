package com.dbms.project.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class ContactForm {
    private int id;
    @NotBlank(message="Reply cannot be blank")
    private String reply;
    @NotBlank(message="Query cannot be blank")
    private String query;
    private int customerId;
}
