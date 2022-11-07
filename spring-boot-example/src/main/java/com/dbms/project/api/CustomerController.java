package com.dbms.project.api;

import com.dbms.project.model.Customer;
import com.dbms.project.service.CustomerService;
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
    public String deleteCustomer(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
        customerService.deleteCustomer(id);
        return "redirect:/customer";
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

    @GetMapping(path="/customer/{id}/edit")
    public String customerEditForm(@PathVariable("id") int id, Model model) {
        model.addAttribute("customer", customerService.getCustomerById(id));
        return "customer-edit";
    }

    @PostMapping(path = "/customer/{id}/edit")
    public String customerEditSubmit(@PathVariable("id") int id, @Valid @ModelAttribute("customer") Customer customer, BindingResult result, RedirectAttributes redirectAttributes, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("customer", customer);
            return "customer-new";
        }
        customerService.updateCustomer(id, customer);
        return "redirect:/customer";
    }

    @GetMapping(path="/customer/new")
    public String addCustomerForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer-new";
    }
}
