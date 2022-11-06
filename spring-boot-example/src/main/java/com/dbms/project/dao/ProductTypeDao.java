package com.dbms.project.dao;

import com.dbms.project.model.ProductType;
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
public class ProductTypeDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ProductTypeDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int insertProductType(ProductType productType) {
        final String sql = "INSERT INTO productType(name, productImage, warrantyPeriod, quantity) VALUES(?, ?, ?, ?)";
        KeyHolder keyholder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, productType.getName());
            ps.setString(2, productType.getProductImage());
            ps.setInt(3, productType.getWarrantyPeriod());
            ps.setInt(4, productType.getQuantity());


            return ps;
        }, keyholder);
        int id = keyholder.getKey().intValue();

        productType.setId(id);
        return id;
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
        final String sql = "UPDATE productType SET name = ?, productImage = ?, warrantyPeriod = ?, quantity = ? WHERE id = ?";
        return jdbcTemplate.update(sql, productType.getName(), productType.getProductImage(), productType.getWarrantyPeriod(), productType.getQuantity(), id);
    }
}
