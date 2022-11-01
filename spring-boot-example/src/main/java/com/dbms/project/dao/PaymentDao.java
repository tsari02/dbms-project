package com.dbms.project.dao;

import com.dbms.project.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PaymentDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PaymentDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int insertPayment(Payment payment) {
        final String sql = "INSERT INTO payment(customerOrderId, transactionId, billId) VALUES(?, ?, ?)";
        return jdbcTemplate.update(sql, payment.getCustomerOrderId(), payment.getTransactionId(), payment.getBillId());
    }
    
    public List<Payment> getAllPayments() {
        final String sql = "SELECT * from payment";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Payment.class));
    }

    public Payment getPaymentById(int id) {
        final String sql = "SELECT * from payment WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[] {id}, new BeanPropertyRowMapper<>(Payment.class));
    }

    public int deletePayment(int id) {
        final String sql = "DELETE FROM payment WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

    public int updatePayment(int id, Payment payment) {
        final String sql = "UPDATE payment SET customerOrderId = ?, transactionId = ?, billId = ? WHERE id = ?";
        return jdbcTemplate.update(sql, payment.getCustomerOrderId(), payment.getTransactionId(), payment.getBillId(), id);
    }
}
