package com.dbms.project.dao;

import com.dbms.project.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CustomerDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int insertCustomer(Customer customer) {
        final String sql = "INSERT INTO customer(firstName, middleName, lastName, contactNumber, dateOfBirth, emailId, city, state, postalCode, country, street) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, customer.getFirstName(), customer.getMiddleName(), customer.getLastName(), customer.getContactNumber(), customer.getDateOfBirth(), customer.getEmailId(), customer.getCity(), customer.getState(), customer.getPostalCode(), customer.getCountry(), customer.getStreet());
    }

    public List<Customer> getAllCustomers() {
        final String sql = "SELECT * from customer";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Customer.class));
    }

    public Customer getCustomerById(int id) {
        final String sql = "SELECT * from customer WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[] {id}, new BeanPropertyRowMapper<>(Customer.class));
    }

    public int deleteCustomer(int id) {
        final String sql = "DELETE FROM customer WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

    public int updateCustomer(int id, Customer customer) {
        final String sql = "UPDATE customer SET firstName = ?, middleName = ?, lastName = ?, contactNumber = ?, dateOfBirth = ?, emailId = ?, city = ?, state = ?, postalCode = ?, country = ?, street = ? WHERE id = ?";
        return jdbcTemplate.update(sql, customer.getFirstName(), customer.getMiddleName(), customer.getLastName(), customer.getContactNumber(), customer.getDateOfBirth(), customer.getEmailId(), customer.getCity(), customer.getState(), customer.getPostalCode(), customer.getCountry(), customer.getStreet(), id);
    }
}
