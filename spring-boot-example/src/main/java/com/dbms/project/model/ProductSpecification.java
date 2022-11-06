package com.dbms.project.model;

import lombok.Data;

import java.util.Date;
import java.lang.Boolean;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ProductSpecification {
    private int id;
    @NotBlank
    private String specificationName;
    @NotBlank
    private String specificationText;
    @NotNull
    private int productTypeId; //fk
}
