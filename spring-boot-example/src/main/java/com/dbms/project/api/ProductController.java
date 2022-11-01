package com.dbms.project.api;

import com.dbms.project.model.Product;
import com.dbms.project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RequestMapping("api/product")
@Controller
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    @ResponseBody
    public void addProduct(@Valid @NotNull @RequestBody Product product) {
        productService.insertProduct(product);
    }

    @GetMapping
    @ResponseBody
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @DeleteMapping(path="{id}")
    @ResponseBody
    public void deleteProduct(@PathVariable("id") int id) {
        productService.deleteProduct(id);
    }

    @GetMapping(path="{id}")
    @ResponseBody
    public Product getProductById(@PathVariable("id") int id) {
        return productService.getProductById(id);
    }

    @PutMapping(path="{id}")
    @ResponseBody
    public void updateProduct(@PathVariable("id") int id, @Valid @NotNull @RequestBody Product product) {
        productService.updateProduct(id, product);
    }
}
