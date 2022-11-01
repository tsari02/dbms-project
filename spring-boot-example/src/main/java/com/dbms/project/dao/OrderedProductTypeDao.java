package com.dbms.project.dao;

import com.dbms.project.model.OrderedProductType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderedProductTypeDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public OrderedProductTypeDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int insertOrderedProductType(OrderedProductType orderedProductType) {
        final String sql = "INSERT INTO orderedProductType(supplierOrderId, quantity, productTypeId, numberDelivered) VALUES(?, ?, ?, ?)";
        return jdbcTemplate.update(sql, orderedProductType.getSupplierOrderId(), orderedProductType.getQuantity(), orderedProductType.getProductTypeId(), orderedProductType.getNumberDelivered());
    }

    public List<OrderedProductType> getAllOrderedProductTypes() {
        final String sql = "SELECT * from orderedProductType";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(OrderedProductType.class));
    }

    public OrderedProductType getOrderedProductTypeById(int id) {
        final String sql = "SELECT * from orderedProductType WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[] {id}, new BeanPropertyRowMapper<>(OrderedProductType.class));
    }

    public int deleteOrderedProductType(int id) {
        final String sql = "DELETE FROM orderedProductType WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

    public int updateOrderedProductType(int id, OrderedProductType orderedProductType) {
        final String sql = "UPDATE orderedProductType SET supplierOrderId = ?, quantity = ?, productTypeId = ?, contactNumber = ?, numberDelivered = ? WHERE id = ?";
        return jdbcTemplate.update(sql, orderedProductType.getSupplierOrderId(), orderedProductType.getQuantity(), orderedProductType.getProductTypeId(), orderedProductType.getNumberDelivered(), id);
    }
}

