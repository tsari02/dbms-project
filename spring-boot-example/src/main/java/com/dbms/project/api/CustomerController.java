package com.dbms.project.api;

import com.dbms.project.model.Customer;
import com.dbms.project.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

// @RequestMapping("api/customer")
@Controller
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping(path="/customer")
    public String addCustomer(@Valid Customer customer, BindingResult result, RedirectAttributes redirectAttributes, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("customer", customer);
            return "customer-new";
        }
        customerService.insertCustomer(customer);
        return "redirect:/customer";
    }

    @GetMapping(path="/customer")
    public String getAllCustomers(Model model) {
        model.addAttribute("customers", customerService.getAllCustomers());
        return "show-customers";
    }

    @PostMapping(path="/api/customer/{id}/delete")
    @ResponseBody
    public void deleteCustomer(@PathVariable("id") int id) {
        customerService.deleteCustomer(id);
    }

    @GetMapping(path="/api/customer/{id}")
    @ResponseBody
    public Customer getCustomerById(@PathVariable("id") int id) {
        return customerService.getCustomerById(id);
    }

    @PostMapping(path="/api/customer/{id}/edit")
    @ResponseBody
    public void updateCustomer(@PathVariable("id") int id, @Valid @NotNull @RequestBody Customer customer) {
        customerService.updateCustomer(id, customer);
    }

    @GetMapping(path="/customer/new")
    public String addCustomerForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer-new";
    }
}
