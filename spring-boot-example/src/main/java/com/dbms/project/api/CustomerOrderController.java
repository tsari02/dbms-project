package com.dbms.project.api;

import com.dbms.project.model.CustomerOrder;
import com.dbms.project.service.CustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;


// @RequestMapping("api/order/customer")
@Controller
public class CustomerOrderController {
    private final CustomerOrderService customerOrderService;

    @Autowired
    public CustomerOrderController(CustomerOrderService customerOrderService) {
        this.customerOrderService = customerOrderService;
    }

    @PostMapping(path="/api/order/customer")
    @ResponseBody
    public void addCustomerOrder(@Valid @NotNull @RequestBody CustomerOrder customerOrder) {
        customerOrderService.insertCustomerOrder(customerOrder);
    }

    @GetMapping(path="/api/order/customer")
    @ResponseBody
    public List<CustomerOrder> getAllCustomerOrders() {
        return customerOrderService.getAllCustomerOrders();
    }

    @PostMapping(path="/api/order/customer/{id}/delete")
    @ResponseBody
    public void deleteCustomerOrder(@PathVariable("id") int id) {
        customerOrderService.deleteCustomerOrder(id);
    }

    @GetMapping(path="/api/order/customer/{id}")
    @ResponseBody
    public CustomerOrder getCustomerOrderById(@PathVariable("id") int id) {
        return customerOrderService.getCustomerOrderById(id);
    }

    @PostMapping(path="/api/order/customer/{id}/edit")
    @ResponseBody
    public void updateCustomerOrder(@PathVariable("id") int id, @Valid @NotNull @RequestBody CustomerOrder customerOrder) {
        customerOrderService.updateCustomerOrder(id, customerOrder);
    }
}
