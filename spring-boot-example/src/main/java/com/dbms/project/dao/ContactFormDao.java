package com.dbms.project.dao;

import com.dbms.project.model.ContactForm;
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
public class ContactFormDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ContactFormDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int insertContactForm(ContactForm contactForm) {
        final String sql = "INSERT INTO contactForm(emailId,name,contactNumber,reply,query,customerId) VALUES(?, ?, ?, ?, ?, ?)";
        KeyHolder keyholder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, contactForm.getReply());
            ps.setString(2, contactForm.getQuery());
            ps.setInt(3, contactForm.getCustomerId());

            return ps;
        }, keyholder);
        int id = keyholder.getKey().intValue();

        contactForm.setId(id);
        return id;
    }

    public List<ContactForm> getAllContactForms() {
        final String sql = "SELECT * from contactForm";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ContactForm.class));
    }

    public ContactForm getContactFormById(int id) {
        final String sql = "SELECT * from contactForm WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[] {id}, new BeanPropertyRowMapper<>(ContactForm.class));
    }

    public int deleteContactForm(int id) {
        final String sql = "DELETE FROM contactForm WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

    public int updateContactForm(int id, ContactForm contactForm) {
        final String sql = "UPDATE contactForm reply = ?,query = ?,customerId = ? WHERE id= ?";
        return jdbcTemplate.update(sql, contactForm.getReply(), contactForm.getQuery(), contactForm.getCustomerId(), id);
    }
}
