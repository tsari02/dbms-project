package com.dbms.project.dao;

import com.dbms.project.model.ProductType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductTypeDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ProductTypeDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int insertProductType(ProductType productType) {
        final String sql = "INSERT INTO productType(type, productImage, warrantyPeriod, quantity) VALUES(?, ?, ?, ?)";
        return jdbcTemplate.update(sql, productType.getType(), productType.getProductImage(), productType.getWarrantyPeriod(), productType.getQuantity());
    }

    public List<ProductType> getAllProductTypes() {
        final String sql = "SELECT * from productType";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ProductType.class));
    }

    public ProductType getProductTypeById(int id) {
        final String sql = "SELECT * from productType WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[] {id}, new BeanPropertyRowMapper<>(ProductType.class));
    }

    public int deleteProductType(int id) {
        final String sql = "DELETE FROM productType WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

    public int updateProductType(int id, ProductType productType) {
        final String sql = "UPDATE productType SET type = ?, productImage = ?, warrantyPeriod = ?, quantity = ? WHERE id = ?";
        return jdbcTemplate.update(sql, productType.getType(), productType.getProductImage(), productType.getWarrantyPeriod(), productType.getQuantity(), id);
    }
}
