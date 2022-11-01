package com.dbms.project.api;

import com.dbms.project.model.ProductType;
import com.dbms.project.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RequestMapping("api/productType")
@Controller
public class ProductTypeController {
    private final ProductTypeService productTypeService;

    @Autowired
    public ProductTypeController(ProductTypeService productTypeService) {
        this.productTypeService = productTypeService;
    }

    @PostMapping
    @ResponseBody
    public void addProductType(@Valid @NotNull @RequestBody ProductType productType) {
        productTypeService.insertProductType(productType);
    }

    @GetMapping
    @ResponseBody
    public List<ProductType> getAllProductTypes() {
        return productTypeService.getAllProductTypes();
    }

    @DeleteMapping(path="{id}")
    @ResponseBody
    public void deleteProductType(@PathVariable("id") int id) {
        productTypeService.deleteProductType(id);
    }

    @GetMapping(path="{id}")
    @ResponseBody
    public ProductType getProductTypeById(@PathVariable("id") int id) {
        return productTypeService.getProductTypeById(id);
    }

    @PutMapping(path="{id}")
    @ResponseBody
    public void updateProductType(@PathVariable("id") int id, @Valid @NotNull @RequestBody ProductType productType) {
        productTypeService.updateProductType(id, productType);
    }
}
