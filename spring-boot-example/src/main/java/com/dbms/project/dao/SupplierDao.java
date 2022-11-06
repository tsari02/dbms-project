package com.dbms.project.dao;

import com.dbms.project.model.Supplier;
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
public class SupplierDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public SupplierDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int insertSupplier(Supplier supplier) {
        final String sql = "INSERT INTO supplier(firstName, middleName, lastName, contactNumber, city, state, postalCode, country, street) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        KeyHolder keyholder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, supplier.getFirstName());
            ps.setString(2, supplier.getMiddleName());
            ps.setString(3, supplier.getLastName());
            ps.setString(4, supplier.getContactNumber());
            ps.setString(5, supplier.getCity());
            ps.setString(6, supplier.getState());
            ps.setString(7, supplier.getPostalCode());
            ps.setString(8, supplier.getCountry());
            ps.setString(9, supplier.getStreet());

            return ps;
        }, keyholder);
        int id = keyholder.getKey().intValue();

        supplier.setId(id);
        return id;
    }

    public List<Supplier> getAllSuppliers() {
        final String sql = "SELECT * from supplier";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Supplier.class));
    }

    public Supplier getSupplierById(int id) {
        final String sql = "SELECT * from supplier WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[] {id}, new BeanPropertyRowMapper<>(Supplier.class));
    }

    public int deleteSupplier(int id) {
        final String sql = "DELETE FROM supplier WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

    public int updateSupplier(int id, Supplier supplier) {
        final String sql = "UPDATE supplier SET firstName = ?, middleName = ?, lastName = ?, contactNumber = ?, city = ?, state = ?, street = ?, postalCode = ?, country = ?, street = ? WHERE id = ?";
        return jdbcTemplate.update(sql, supplier.getFirstName(), supplier.getMiddleName(), supplier.getLastName(), supplier.getContactNumber(), supplier.getCity(), supplier.getState(), supplier.getPostalCode(), supplier.getCountry(), supplier.getStreet(), id);
    }
}
