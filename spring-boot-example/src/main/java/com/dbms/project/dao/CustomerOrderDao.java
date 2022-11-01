package com.dbms.project.dao;

import com.dbms.project.model.CustomerOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerOrderDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CustomerOrderDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int insertCustomerOrder(CustomerOrder customerOrder) {
        final String sql = "INSERT INTO customerOrder(id ,deliveryAgentAssigned ,verificationStatus ,deliveryDate ,orderedDate ,customerId, employeeId) VALUES(?, ?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, customerOrder.getId(), customerOrder.getDeliveryAgentAssigned(), customerOrder.getVerificationStatus(), customerOrder.getDeliveryDate(), customerOrder.getOrderedDate(), customerOrder.getCustomerId(), customerOrder.getEmployeeId());
    }

    public List<CustomerOrder> getAllCustomerOrders() {
        final String sql = "SELECT * from customerOrder";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(CustomerOrder.class));
    }

    public CustomerOrder getCustomerOrderById(int id) {
        final String sql = "SELECT * from customerOrder WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[] {id}, new BeanPropertyRowMapper<>(CustomerOrder.class));
    }

    public int deleteCustomerOrder(int id) {
        final String sql = "DELETE FROM customerOrder WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

    public int updateCustomerOrder(int id, CustomerOrder customerOrder) {
        final String sql = "UPDATE customerOrder SET id = ?, deliveryAgentAssigned = ?,verificationStatus = ?,deliveryDate = ?,orderedDate = ?,customerId = ?,employeeId = ?";
        return jdbcTemplate.update(sql, customerOrder.getId(), customerOrder.getDeliveryAgentAssigned(), customerOrder.getVerificationStatus(), customerOrder.getDeliveryDate(), customerOrder.getOrderedDate(), customerOrder.getCustomerId(), customerOrder.getEmployeeId());
    }
}
