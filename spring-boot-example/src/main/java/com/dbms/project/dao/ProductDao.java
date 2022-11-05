package com.dbms.project.dao;

import com.dbms.project.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ProductDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int insertProduct(Product product) {
        final String sql = "INSERT INTO product(supplierOrderId, productTypeId, customerOrderId) VALUES(?, ?, ?)";
        return jdbcTemplate.update(sql, product.getSupplierOrderId(), product.getProductTypeId(), product.getCustomerOrderId());
    }

    public List<Product> getAllProducts() {
        final String sql = "SELECT * from product";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Product.class));
    }

    public Product getProductById(int id) {
        final String sql = "SELECT * from product WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[] {id}, new BeanPropertyRowMapper<>(Product.class));
    }

    public int deleteProduct(int id) {
        final String sql = "DELETE FROM product WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

    public int updateProduct(int id, Product product) {
        final String sql = "UPDATE product SET customerOrderId = ?, supplierOrderId = ?, productTypeId = ? WHERE id = ?";
        return jdbcTemplate.update(sql, product.getCustomerOrderId(), product.getSupplierOrderId(), product.getProductTypeId(), id);
    }
}
