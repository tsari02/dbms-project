package com.dbms.project.dao;

import com.dbms.project.model.Warranty;
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
public class WarrantyDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public WarrantyDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int insertWarranty(Warranty warranty) {
        final String sql = "INSERT INTO warranty(coverage, productId, customerId, endDate) VALUES(?, ?, ?, ?)";
        KeyHolder keyholder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, warranty.getCoverage());
            ps.setInt(2, warranty.getProductId());
            ps.setInt(3, warranty.getCustomerId());
            ps.setDate(4, warranty.getEndDate());

            return ps;
        }, keyholder);
        int id = keyholder.getKey().intValue();

        warranty.setId(id);
        return id;
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
