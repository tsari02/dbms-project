package com.dbms.project.api;

import com.dbms.project.model.Payment;
import com.dbms.project.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

// @RequestMapping("api/payment")
@Controller
public class PaymentController {
    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping(path="/api/payment")
    @ResponseBody
    public void addPayment(@Valid @NotNull @RequestBody Payment payment) {
        paymentService.insertPayment(payment);
    }

    @GetMapping(path="/api/payment")
    @ResponseBody
    public List<Payment> getAllPayments() {
        return paymentService.getAllPayments();
    }

    @PostMapping(path="/api/payment/{id}/delete")
    @ResponseBody
    public void deletePayment(@PathVariable("id") int id) {
        paymentService.deletePayment(id);
    }

    @GetMapping(path="/api/payment/{id}")
    @ResponseBody
    public Payment getPaymentById(@PathVariable("id") int id) {
        return paymentService.getPaymentById(id);
    }

    @PostMapping(path="/api/payment/{id}/edit")
    @ResponseBody
    public void updatePayment(@PathVariable("id") int id, @Valid @NotNull @RequestBody Payment payment) {
        paymentService.updatePayment(id, payment);
    }
}
