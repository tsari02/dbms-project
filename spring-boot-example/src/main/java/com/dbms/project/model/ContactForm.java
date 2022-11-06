package com.dbms.project.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class ContactForm {
    private int id;
    @NotBlank
    private String reply;
    @NotBlank
    private String query;
    @NotNull
    private int customerId;
}
