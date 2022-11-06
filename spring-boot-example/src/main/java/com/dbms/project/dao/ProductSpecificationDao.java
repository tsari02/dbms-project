package com.dbms.project.dao;

import com.dbms.project.model.ProductSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductSpecificationDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ProductSpecificationDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int insertProductSpecification(ProductSpecification productSpecification) {
        final String sql = "INSERT INTO productSpecification(specificationName, specificationText, productTypeId) VALUES(?, ?, ?)";
        return jdbcTemplate.update(sql, productSpecification.getSpecificationName(), productSpecification.getSpecificationText(), productSpecification.getProductTypeId());
    }

    public List<ProductSpecification> getAllProductSpecifications() {
        final String sql = "SELECT * from productSpecification";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ProductSpecification.class));
    }

    public ProductSpecification getProductSpecificationById(int id) {
        final String sql = "SELECT * from productSpecification WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[] {id}, new BeanPropertyRowMapper<>(ProductSpecification.class));
    }

    public int deleteProductSpecification(int id) {
        final String sql = "DELETE FROM productSpecification WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

    public int updateProductSpecification(int id, ProductSpecification productSpecification) {
        final String sql = "UPDATE productSpecification SET specificationName = ?, specificationText = ?, productTypeId = ? WHERE id = ?";
        return jdbcTemplate.update(sql, productSpecification.getSpecificationName(), productSpecification.getSpecificationText(), productSpecification.getProductTypeId(), id);
    }
}
