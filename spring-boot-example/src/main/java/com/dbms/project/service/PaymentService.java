package com.dbms.project.service;

import com.dbms.project.dao.PaymentDao;
import com.dbms.project.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {
    private final PaymentDao paymentDao;
    
    @Autowired
    public PaymentService(PaymentDao paymentDao) {
        this.paymentDao = paymentDao;
    }

    public int insertPayment(Payment payment) {
        return paymentDao.insertPayment(payment);
    }

    public List<Payment> getAllPayments() {
        return paymentDao.getAllPayments();
    }

    public Payment getPaymentById(int id) {
        return paymentDao.getPaymentById(id);
    }

    public int deletePayment(int id) {
        return paymentDao.deletePayment(id);
    }

    public int updatePayment(int id, Payment payment) {
        return paymentDao.updatePayment(id, payment);
    }
}
