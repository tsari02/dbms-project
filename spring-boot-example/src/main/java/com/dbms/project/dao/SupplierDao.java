package com.dbms.project.dao;

import com.dbms.project.model.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

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
        return jdbcTemplate.update(sql, supplier.getFirstName(), supplier.getMiddleName(), supplier.getLastName(), supplier.getContactNumber(), supplier.getCity(), supplier.getState(), supplier.getPostalCode(), supplier.getCountry(), supplier.getStreet());
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
