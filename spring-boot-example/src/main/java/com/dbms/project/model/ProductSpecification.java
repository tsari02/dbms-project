package com.dbms.project.model;

import lombok.Data;

import java.util.Date;
import java.lang.Boolean;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ProductSpecification {
    private int id;
    @NotBlank(message="Specification Name cannot be blank")
    private String specificationName;
    @NotBlank(message="Specification Text cannot be blank")
    private String specificationText;
    private int productTypeId; //fk
}
