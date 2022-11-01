package com.dbms.project.dao;

import com.dbms.project.model.OrderedProductTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderedProductTypesDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public OrderedProductTypesDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int insertOrderedProductTypes(OrderedProductTypes orderedProductTypes) {
        final String sql = "INSERT INTO orderedProductTypes(supplierOrderId, quantity, productTypeId, numberDelivered) VALUES(?, ?, ?, ?)";
        return jdbcTemplate.update(sql, orderedProductTypes.getSupplierOrderId(), orderedProductTypes.getQuantity(), orderedProductTypes.getProductTypeId(), orderedProductTypes.getNumberDelivered());
    }

    public List<OrderedProductTypes> getAllOrderedProductTypes() {
        final String sql = "SELECT * from orderedProductTypes";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(OrderedProductTypes.class));
    }

    public OrderedProductTypes getOrderedProductTypesById(int id) {
        final String sql = "SELECT * from orderedProductTypes WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[] {id}, new BeanPropertyRowMapper<>(OrderedProductTypes.class));
    }

    public int deleteOrderedProductTypes(int id) {
        final String sql = "DELETE FROM orderedProductTypes WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

    public int updateOrderedProductTypes(int id, OrderedProductTypes orderedProductTypes) {
        final String sql = "UPDATE orderedProductTypes SET supplierOrderId = ?, quantity = ?, productTypeId = ?, numberDelivered = ? WHERE id = ?";
        return jdbcTemplate.update(sql, orderedProductTypes.getSupplierOrderId(), orderedProductTypes.getQuantity(), orderedProductTypes.getProductTypeId(), orderedProductTypes.getNumberDelivered(), id);
    }
}
