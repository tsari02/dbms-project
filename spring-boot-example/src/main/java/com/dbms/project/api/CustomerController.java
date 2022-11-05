package com.dbms.project.api;

import com.dbms.project.model.Customer;
import com.dbms.project.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(path="api/customer")
    @ResponseBody
    public void addCustomer(@Valid @NotNull @RequestBody Customer customer) {
        customerService.insertCustomer(customer);
    }

    @GetMapping(path="/api/customer")
    @ResponseBody
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
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
}
