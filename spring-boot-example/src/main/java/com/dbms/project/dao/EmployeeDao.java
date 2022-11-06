package com.dbms.project.dao;


import com.dbms.project.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public EmployeeDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int insertEmployee(Employee employee) {
        final String sql = "INSERT INTO employee(firstName, middleName, lastName, designation, salary, contactNumber, dateOfBirth, emailID, city, state, postalCode, country, street, username, password) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        KeyHolder keyholder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, employee.getFirstName());
            ps.setString(2, employee.getMiddleName());
            ps.setString(1, employee.getLastName());
            ps.setInt(4, employee.getSalary());
            ps.setString(5, employee.getContactNumber());
            ps.setDate(6, employee.getDateOfBirth());
            ps.setString(7, employee.getEmailId());
            ps.setString(8, employee.getCity());
            ps.setString(9, employee.getState());
            ps.setString(10, employee.getPostalCode());
            ps.setString(11, employee.getCountry());
            ps.setString(12, employee.getStreet());
            ps.setString(13, employee.getUsername());
            ps.setString(14, employee.getPassword());

            return ps;
        }, keyholder);
        return (int) keyholder.getKey();
    }

    public List<Employee> getAllEmployees() {
        final String sql = "SELECT * from employee";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Employee.class));
    }

    public Employee getEmployeeById(int id) {
        final String sql = "SELECT * from employee WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[] {id}, new BeanPropertyRowMapper<>(Employee.class));
    }

    public int deleteEmployee(int id) {
        final String sql = "DELETE FROM employee WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

    public int updateEmployee(int id, Employee employee) {
        final String sql = "UPDATE employee SET firstName = ?, middleName = ?, lastName = ?, designation = ?, salary = ?, contactNumber = ?, dateOfBirth = ?, emailId = ?, city = ?, state = ?, postalCode = ?, country = ?, street = ? WHERE id = ?";
        return jdbcTemplate.update(sql, employee.getFirstName(), employee.getMiddleName(), employee.getLastName(), employee.getDesignation(), employee.getSalary(), employee.getContactNumber(), employee.getDateOfBirth(), employee.getEmailId(), employee.getCity(), employee.getState(), employee.getPostalCode(), employee.getCountry(), employee.getStreet(), id);
    }

    public Optional<Employee> findEmployeeByUsername(String username) {
        final String sql = "SELECT * from employee WHERE username = ?";
        return Optional.ofNullable(jdbcTemplate.queryForObject(sql, new Object[] {username}, new BeanPropertyRowMapper<>(Employee.class)));
    }
}
