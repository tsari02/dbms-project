package com.dbms.project.dao;

import com.dbms.project.model.CustomerOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class CustomerOrderDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CustomerOrderDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int insertCustomerOrder(CustomerOrder customerOrder) {
        final String sql = "INSERT INTO customerOrder(deliveryAgentAssigned ,verificationStatus ,deliveryDate ,orderedDate ,customerId, employeeId) VALUES(?, ?, ?, ?, ?, ?)";
        KeyHolder keyholder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setBoolean(1, customerOrder.getDeliveryAgentAssigned());
            ps.setBoolean(2, customerOrder.getVerificationStatus());
            ps.setDate(3, customerOrder.getDeliveryDate());
            ps.setDate(4, customerOrder.getOrderedDate());
            ps.setInt(5, customerOrder.getCustomerId());
            ps.setInt(6, customerOrder.getEmployeeId());
            // ps.setBoolean(7, customerOrder.getOrderCompleted());

            return ps;
        }, keyholder);
        int id = keyholder.getKey().intValue();

        customerOrder.setId(id);
        return id;

    }


    public List<CustomerOrder> getAllCustomerOrders() {
        final String sql = "SELECT c.id as 'id', c.deliveryAgentAssigned as 'deliveryAgentAssigned', c.verificationStatus as 'verificationStatus', c.deliveryDate as 'deliveryDate', c.orderedDate as 'orderedDate', c.customerId as 'customerId', c.employeeId as 'employeeId', (SELECT IF(COUNT(*) > 0, 'true', 'false') "+
        "FROM payment p WHERE p.customerOrderId = c.id" + 
        " ) AS 'orderCompleted'" +
        " from customerOrder c";
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
        final String sql = "UPDATE customerOrder SET deliveryAgentAssigned = ?,verificationStatus = ?,deliveryDate = ?,orderedDate = ?,customerId = ?,employeeId = ? WHERE id = ?";
        return jdbcTemplate.update(sql, customerOrder.getDeliveryAgentAssigned(), customerOrder.getVerificationStatus(), customerOrder.getDeliveryDate(), customerOrder.getOrderedDate(), customerOrder.getCustomerId(), customerOrder.getEmployeeId(), id);
    }
}
