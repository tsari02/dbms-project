package com.dbms.project.dao;

import com.dbms.project.model.Customer;
import com.dbms.project.model.Product;
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
public class ProductDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ProductDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int insertProduct(Product product) {
        final String sql = "INSERT INTO product(supplierOrderId, productTypeId, customerOrderId) VALUES(?, ?, ?)";
        KeyHolder keyholder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, product.getSupplierOrderId());
            ps.setInt(2, product.getProductTypeId());
            ps.setInt(3, product.getCustomerOrderId());

            return ps;
        }, keyholder);
        int id = keyholder.getKey().intValue();

        final String sql2 = "UPDATE productType SET quantity = quantity + 1 WHERE id = ?";
        jdbcTemplate.update(sql2, product.getProductTypeId());

        product.setId(id);
        return id;
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

    public List<Product> getProductsByCustomerOrderId(int customerOrderId) {
        final String sql = "SELECT * from product WHERE customerOrderId = ?";
        return jdbcTemplate.query(sql, new Object[] {customerOrderId}, new BeanPropertyRowMapper<>(Product.class));
    }
}
