package com.dbms.project.dao;

import com.dbms.project.model.Warranty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WarrantyDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public WarrantyDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int insertWarranty(Warranty warranty) {
        final String sql = "INSERT INTO warranty(coverage, productId, customerId, endDate) VALUES(?, ?, ?, ?)";
        return jdbcTemplate.update(sql, warranty.getCoverage(), warranty.getProductId(), warranty.getCustomerId(), warranty.getEndDate() );
    }

    public List<Warranty> getAllWarranties() {
        final String sql = "SELECT * from warranty";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Warranty.class));
    }

    public Warranty getWarrantyById(int id) {
        final String sql = "SELECT * from warranty WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[] {id}, new BeanPropertyRowMapper<>(Warranty.class));
    }

    public int deleteWarranty(int id) {
        final String sql = "DELETE FROM warranty WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

    public int updateWarranty(int id, Warranty warranty) {
        final String sql = "UPDATE warranty SET coverage = ?, productId = ?, customerId = ?, endDate = ? WHERE id = ?";
        return jdbcTemplate.update(sql, warranty.getCoverage(), warranty.getProductId(), warranty.getCustomerId(), warranty.getEndDate(), id);
    }
}
