package com.dbms.project.api;

import com.dbms.project.model.Customer;
import com.dbms.project.model.Supplier;
import com.dbms.project.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

// @RequestMapping("api/supplier")
@Controller
public class SupplierController {
    private final SupplierService supplierService;

    @Autowired
    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @PostMapping(path="/supplier")
    public String addSupplier(@Valid Supplier supplier, BindingResult result, RedirectAttributes redirectAttributes, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("supplier", supplier);
            return "supplier-new";
        }
        supplierService.insertSupplier(supplier);
        return "redirect:/supplier";
    }

    @GetMapping(path="/supplier")
    public String getAllSuppliers(Model model) {
        model.addAttribute("suppliers", supplierService.getAllSuppliers());
        return "show-suppliers";
    }

    @PostMapping(path="/api/supplier/{id}/delete")
    public String deleteSupplier(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
        supplierService.deleteSupplier(id);
        return "redirect:/supplier";
    }
    @GetMapping(path="/api/supplier/{id}")
    @ResponseBody
    public Supplier getSupplierById(@PathVariable("id") int id) {
        return supplierService.getSupplierById(id);
    }



    @PostMapping(path="/api/supplier/{id}/edit")
    @ResponseBody
    public void updateSupplier(@PathVariable("id") int id, @Valid @NotNull @RequestBody Supplier supplier) {
        supplierService.updateSupplier(id, supplier);
    }



    @PostMapping(path = "/supplier/{id}/edit")
    public String supplierEditSubmit(@PathVariable("id") int id, @Valid @ModelAttribute("supplier") Supplier supplier, Authentication authentication, RedirectAttributes redirectAttributes) {
        supplierService.updateSupplier(id, supplier);
        return "redirect:/supplier";
    }

    @GetMapping(path="/supplier/new")
    public String addSupplierForm(Model model) {
        model.addAttribute("supplier", new Supplier());
        return "supplier-new";
    }

    @GetMapping(path="/supplier/{id}/edit")
    public String supplierEditForm(@PathVariable("id") int id,Authentication authentication, Model model) {
        model.addAttribute("supplier", supplierService.getSupplierById(id));
        return "supplier-edit";
    }
}
