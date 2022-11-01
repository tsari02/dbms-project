package com.dbms.project.dao;

import com.dbms.project.model.ContactForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ContactFormDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ContactFormDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int insertContactForm(ContactForm contactForm) {
        final String sql = "INSERT INTO contactForm(id,emailId,name,contactNumber,reply,query,customerId) VALUES(?, ?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, contactForm.getId(), contactForm.getEmailId(), contactForm.getName(), contactForm.getContactNumber(), contactForm.getReply(), contactForm.getQuery(), contactForm.getCustomerId());
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
        final String sql = "UPDATE contactForm SET id = ?,emailId = ?,name = ?,contactNumber = ?,reply = ?,query = ?,customerId = ?";
        return jdbcTemplate.update(sql, contactForm.getId(), contactForm.getEmailId(), contactForm.getName(), contactForm.getContactNumber(), contactForm.getReply(), contactForm.getQuery(), contactForm.getCustomerId());
    }
}
