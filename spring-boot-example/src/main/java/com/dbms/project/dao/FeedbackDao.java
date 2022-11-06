package com.dbms.project.dao;

import com.dbms.project.model.Feedback;
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
public class FeedbackDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public FeedbackDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int insertFeedback(Feedback feedback) {
        final String sql = "INSERT INTO feedback(reviews, complaints, suggestions, rating, customerOrderId) VALUES(?, ?, ?, ?, ?)";
        KeyHolder keyholder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, feedback.getReviews());
            ps.setString(2, feedback.getComplaints());
            ps.setString(3, feedback.getSuggestions());
            ps.setInt(4, feedback.getRating());
            ps.setInt(5, feedback.getCustomerOrderId());


            return ps;
        }, keyholder);
        int id = keyholder.getKey().intValue();

        feedback.setId(id);
        return id;
    }

    public List<Feedback> getAllFeedbacks() {
        final String sql = "SELECT * from feedback";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Feedback.class));
    }

    public Feedback getFeedbackById(int id) {
        final String sql = "SELECT * from feedback WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[] {id}, new BeanPropertyRowMapper<>(Feedback.class));
    }

    public int deleteFeedback(int id) {
        final String sql = "DELETE FROM feedback WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

    public int updateFeedback(int id, Feedback feedback) {
        final String sql = "UPDATE feedback SET reviews = ?, complaints = ?, suggestions = ?, rating = ?, customerOrderId = ? WHERE id = ?";
        return jdbcTemplate.update(sql, feedback.getReviews(), feedback.getComplaints(), feedback.getSuggestions(), feedback.getRating(), feedback.getCustomerOrderId(), id);
    }
}
