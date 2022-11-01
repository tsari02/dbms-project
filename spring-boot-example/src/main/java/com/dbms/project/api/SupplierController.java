package com.dbms.project.api;

import com.dbms.project.model.Supplier;
import com.dbms.project.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
@RequestMapping("api/supplier")
@Controller
public class SupplierController {
    private final SupplierService supplierService;

    @Autowired
    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @PostMapping
    @ResponseBody
    public void addSupplier(@Valid @NotNull @RequestBody Supplier supplier) {
        supplierService.insertSupplier(supplier);
    }

    @GetMapping
    @ResponseBody
    public List<Supplier> getAllSuppliers() {
        return supplierService.getAllSuppliers();
    }

    @DeleteMapping(path="{id}")
    @ResponseBody
    public void deleteSupplier(@PathVariable("id") int id) {
        supplierService.deleteSupplier(id);
    }

    @GetMapping(path="{id}")
    @ResponseBody
    public Supplier getSupplierById(@PathVariable("id") int id) {
        return supplierService.getSupplierById(id);
    }

    @PutMapping(path="{id}")
    @ResponseBody
    public void updateSupplier(@PathVariable("id") int id, @Valid @NotNull @RequestBody Supplier supplier) {
        supplierService.updateSupplier(id, supplier);
    }
}
