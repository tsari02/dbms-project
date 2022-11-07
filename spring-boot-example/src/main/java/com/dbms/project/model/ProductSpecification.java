package com.dbms.project.model;

import lombok.Data;

import java.util.Date;
import java.lang.Boolean;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class ProductSpecification {
    private int id;
    @Size(min=1, max=20, message="Length of Specification Name must be between 1 and 20 characters")
    @NotBlank(message="Specification Name cannot be blank")
    private String specificationName;
    @Size(min=1, max=100, message="Length of Specification Text must be between 1 and 100 characters")
    @NotBlank(message="Specification Text cannot be blank")
    private String specificationText;
    private int productTypeId; //fk
}
