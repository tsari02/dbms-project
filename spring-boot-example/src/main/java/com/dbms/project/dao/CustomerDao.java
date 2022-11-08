package com.dbms.project.dao;

import com.dbms.project.model.Customer;
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
public class CustomerDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CustomerDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int insertCustomer(Customer customer) {
        final String sql = "INSERT INTO customer(firstName, middleName, lastName, contactNumber, dateOfBirth, emailId, city, state, postalCode, country, street) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        KeyHolder keyholder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, customer.getFirstName());
            ps.setString(2, customer.getMiddleName());
            ps.setString(3, customer.getLastName());
            ps.setString(4, customer.getContactNumber());
            
            ps.setDate(5, customer.getDateOfBirth());
            ps.setString(6, customer.getEmailId());
            ps.setString(7, customer.getCity());
            ps.setString(8, customer.getState());
            ps.setString(9, customer.getPostalCode());
            ps.setString(10, customer.getCountry());
            ps.setString(11, customer.getStreet());

            return ps;
        }, keyholder);
        int id = keyholder.getKey().intValue();

        customer.setId(id);
        return id;
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

    public List<Customer> findCustomersByContactNo(String contactNo) {
        final String sql = "SELECT * FROM customer WHERE contactNumber LIKE ?";
        List<Customer> customers = jdbcTemplate.query(sql, new Object[] { String.format("%%%s%%", contactNo)}, new BeanPropertyRowMapper<>(Customer.class));
        return customers;
    }
}
