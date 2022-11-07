package com.dbms.project.api;

import com.dbms.project.model.CustomerOrder;
import com.dbms.project.model.Employee;
import com.dbms.project.service.CustomerOrderService;
import com.dbms.project.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;


// @RequestMapping("api/order/customer")
@Controller
public class CustomerOrderController {
    private final CustomerOrderService customerOrderService;
    private final CustomerService customerService;

    @Autowired
    public CustomerOrderController(CustomerOrderService customerOrderService, CustomerService customerService) {
        this.customerOrderService = customerOrderService;
        this.customerService = customerService;
    }


    @GetMapping(path="/order/customer")
    public String getAllCustomerOrders(Model model) {
        model.addAttribute("orders", customerOrderService.getAllCustomerOrders());
        return "show-customer-order";
    }

    @GetMapping(path="/order/customer/new")
    public String addCustomerOrderForm(Model model) {
        model.addAttribute("orders", new CustomerOrder());
        model.addAttribute("customers", customerService.getAllCustomers());
        return "customer-order-new";
    }

    @PostMapping(path="/order/customer/")
    public String initializeCustomerOrder(@RequestParam("customerId") int customerId, Authentication authentication, Model model) {
        CustomerOrder customerOrder = new CustomerOrder();
        customerOrder.setCustomerId(customerId);
        customerOrder.setEmployeeId(((Employee)authentication.getPrincipal()).getId());
        customerOrder.setOrderedDate(new Date(System.currentTimeMillis()));
        customerOrder.setDeliveryAgentAssigned(false);
        customerOrder.setVerificationStatus(false);
        customerOrderService.insertCustomerOrder(customerOrder);
        return "customer-order-add-products";
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
