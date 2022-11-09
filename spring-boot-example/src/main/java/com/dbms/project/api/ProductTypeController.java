package com.dbms.project.api;

import com.dbms.project.model.ProductType;
import com.dbms.project.service.ProductService;
import com.dbms.project.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import java.util.List;

@Controller
public class ProductTypeController {
    private final ProductTypeService productTypeService;

    @Autowired
    public ProductTypeController(ProductTypeService productTypeService) {
        this.productTypeService = productTypeService;
    }

    @PostMapping(path="/api/productType")
    @ResponseBody
    public void addProductType(@Valid @NotNull @RequestBody ProductType productType) {
        productTypeService.insertProductType(productType);
    }
   
    @PostMapping(path="/product")
    public String addProductType(@Valid ProductType productType, BindingResult result, RedirectAttributes redirectAttributes, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("productType", productType);
            return "productType-new";
        }
        productTypeService.insertProductType(productType);
        return "redirect:/product";
    }

    @GetMapping(path="/product/new")
    public String addProductTypeForm(Model model) {
        model.addAttribute("productType", new ProductType());
        return "productType-new";
    }

    @GetMapping(path="/api/productType")
    @ResponseBody
    public List<ProductType> getAllProductTypesApi() {
        return productTypeService.getAllProductTypes();
    }

    @GetMapping(path="/product")
    public String getAllProductTypes(Model model) {
        model.addAttribute("productTypes", productTypeService.getAllProductTypes());
        return "show-product-types";
    }

    @PostMapping(path="/api/productType/{id}/delete")
    @ResponseBody
    public void deleteProductType(@PathVariable("id") int id) {
        productTypeService.deleteProductType(id);
    }

    @GetMapping(path="/api/productType/{id}")
    @ResponseBody
    public ProductType getProductTypeById(@PathVariable("id") int id) {
        return productTypeService.getProductTypeById(id);
    }

    @PostMapping(path="/api/productType/{id}/edit")
    @ResponseBody
    public void updateProductType(@PathVariable("id") int id, @Valid @NotNull @RequestBody ProductType productType) {
        productTypeService.updateProductType(id, productType);
    }

    @GetMapping(path="/product/{id}")
    public String getProductTypeById(@PathVariable("id") int id, Model model) {
        model.addAttribute("productType", productTypeService.getProductTypeById(id));
        model.addAttribute("productSpecifications", productTypeService.getProductTypeSpecificationsbyid(id));
        return "product";
    }
}
