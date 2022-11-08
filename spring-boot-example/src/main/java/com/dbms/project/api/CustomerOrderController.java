package com.dbms.project.api;

import com.dbms.project.model.CustomerOrder;
import com.dbms.project.model.Employee;
import com.dbms.project.model.Bill;
import com.dbms.project.model.Payment;
import com.dbms.project.model.Transaction;
import com.dbms.project.model.ProductType;
import com.dbms.project.service.CustomerOrderService;
import com.dbms.project.service.CustomerService;
import com.dbms.project.service.ProductService;
import com.dbms.project.service.PaymentService;
import com.dbms.project.service.BillService;
import com.dbms.project.service.ProductTypeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Controller
public class CustomerOrderController {
    private final CustomerOrderService customerOrderService;
    private final CustomerService customerService;
    private final ProductService productService;
    private final BillService billService;
    private final PaymentService paymentService;
    private final ProductTypeService productTypeService;

    @Autowired
    public CustomerOrderController(CustomerOrderService customerOrderService, CustomerService customerService, BillService billService,
            ProductService productService, ProductTypeService productTypeService, PaymentService paymentService) {
        this.customerOrderService = customerOrderService;
        this.customerService = customerService;
        this.productService = productService;
        this.billService = billService;
        this.paymentService = paymentService;
        this.productTypeService = productTypeService;
    }

    @GetMapping(path = "/order/customer")
    public String getAllCustomerOrders(Model model) {
        model.addAttribute("orders", customerOrderService.getAllCustomerOrders());
        return "show-customer-order";
    }

    @GetMapping(path = "/order/customer/new")
    public String addCustomerOrderForm(Model model) {
        model.addAttribute("orders", new CustomerOrder());
        model.addAttribute("customers", customerService.getAllCustomers());
        return "customer-order-new";
    }

    @PostMapping(path = "/order/customer/")
    public String initializeCustomerOrder(@RequestParam("customerId") int customerId, Authentication authentication,
            RedirectAttributes redirectAttributes) {
        CustomerOrder customerOrder = new CustomerOrder();
        customerOrder.setCustomerId(customerId);
        customerOrder.setEmployeeId(((Employee) authentication.getPrincipal()).getId());
        customerOrder.setOrderedDate(new Date(System.currentTimeMillis()));
        customerOrder.setDeliveryAgentAssigned(false);
        customerOrder.setVerificationStatus(false);
        customerOrderService.insertCustomerOrder(customerOrder);
        return "redirect:/order/customer/" + customerOrder.getId() + "/add";
    }

    @GetMapping(path = "/order/customer/{id}/add")
    public String addProductsToCustomerOrder(@PathVariable("id") int id, Model model) {
        // model.addAttribute("products", productService.getAllProducts());
        model.addAttribute("customerOrder", customerOrderService.getCustomerOrderById(id));
        model.addAttribute("productTypesOrdered", productTypeService.getAllProductTypesInCustomerOrder(id));
        model.addAttribute("productTypes", productTypeService.getAllProductTypes());
        return "customer-order-add-products";
    }

    @PostMapping(path = "/order/customer/{id}/add")
    public String addProductsToCustomerOrder(@PathVariable("id") int customerOrderId,
            @RequestParam("quantity") int quantity, @RequestParam("productTypeId") int productTypeId,
            Authentication authentication, RedirectAttributes redirectAttributes) {
        productTypeService.addProductTypeToCustomerOrder(productTypeId, quantity, customerOrderId);
        return "redirect:/order/customer/" + customerOrderId + "/add";
    }

    @PostMapping(path = "/api/order/customer")
    @ResponseBody
    public void addCustomerOrder(@Valid @NotNull @RequestBody CustomerOrder customerOrder) {
        customerOrderService.insertCustomerOrder(customerOrder);
    }

    @GetMapping(path = "/api/order/customer")
    @ResponseBody
    public List<CustomerOrder> getAllCustomerOrders() {
        return customerOrderService.getAllCustomerOrders();
    }

    @PostMapping(path = "/api/order/customer/{id}/delete")
    @ResponseBody
    public void deleteCustomerOrder(@PathVariable("id") int id) {
        customerOrderService.deleteCustomerOrder(id);
    }

    @GetMapping(path = "/api/order/customer/{id}")
    @ResponseBody
    public CustomerOrder getCustomerOrderById(@PathVariable("id") int id) {
        return customerOrderService.getCustomerOrderById(id);
    }

    @PostMapping(path = "/api/order/customer/{id}/edit")
    @ResponseBody
    public void updateCustomerOrder(@PathVariable("id") int id,
            @Valid @NotNull @RequestBody CustomerOrder customerOrder) {
        customerOrderService.updateCustomerOrder(id, customerOrder);
    }

    @GetMapping(path = "/order/customer/{id}/bill/new")
    public String createCustomerOrderBill(@PathVariable("id") int customerOrderId, Model model) {
        List<ProductType> productTypes = productTypeService.getAllProductTypesInCustomerOrder(customerOrderId);
        Bill bill = new Bill();
        int amt = 0;
        for (ProductType productType : productTypes) {
            amt += productType.getPrice() * productType.getQuantity();
        }
        bill.setAmount(amt);
        model.addAttribute("bill", bill);
        model.addAttribute("customerOrder", customerOrderService.getCustomerOrderById(customerOrderId));
        return "bill";
    }

    @GetMapping(path = "/order/customer/{id}/bill")
    public String getCustomerOrderBill(@PathVariable("id") int paymentId, Model model) {
        model.addAttribute("paymentId", paymentId);
        Payment payment = paymentService.getPaymentById(paymentId);
        Transaction transaction = new Transaction();
        transaction.setAmount(billService.getNetAmount(payment.getBillId()));
        model.addAttribute("transaction", transaction);
        return "transaction";
    }

    @PostMapping(path = "/order/customer/{id}/bill")
    public String getCustomerOrderBill(@Valid @ModelAttribute Bill bill ,@PathVariable("id") int customerOrderId, RedirectAttributes redirectAttributes) {
        int billId = billService.insertBill(bill);
        Payment payment = new Payment();
        payment.setBillId(billId);
        payment.setCustomerOrderId(customerOrderId);
        int paymentId = paymentService.insertPayment(payment);
        return "redirect:/order/customer/" + paymentId + "/bill";
    }
}
