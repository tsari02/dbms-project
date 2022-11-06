package com.dbms.project.dao;

import com.dbms.project.model.SupplierOrder;
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
public class SupplierOrderDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public SupplierOrderDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int insertSupplierOrder(SupplierOrder supplierOrder) {
        final String sql = "INSERT INTO supplierOrder(dateOfOrder, status, supplierId) VALUES(?, ?, ?)";
        KeyHolder keyholder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setDate(1, supplierOrder.getDateOfOrder());
            ps.setString(2, supplierOrder.getStatus());
            ps.setInt(3, supplierOrder.getSupplierId());


            return ps;
        }, keyholder);
        int id = keyholder.getKey().intValue();

        supplierOrder.setId(id);
        return id;    
    }

    public List<SupplierOrder> getAllSupplierOrders() {
        final String sql = "SELECT * from supplierOrder";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(SupplierOrder.class));
    }

    public SupplierOrder getSupplierOrderById(int id) {
        final String sql = "SELECT * from supplierOrder WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[] {id}, new BeanPropertyRowMapper<>(SupplierOrder.class));
    }

    public int deleteSupplierOrder(int id) {
        final String sql = "DELETE FROM supplierOrder WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

    public int updateSupplierOrder(int id, SupplierOrder supplierOrder) {
        final String sql = "UPDATE supplierOrder SET dateOfOrder = ?, status = ?, supplierId = ? WHERE id = ?";
        return jdbcTemplate.update(sql, supplierOrder.getDateOfOrder(), supplierOrder.getStatus(), supplierOrder.getSupplierId(), id);
    }
}
