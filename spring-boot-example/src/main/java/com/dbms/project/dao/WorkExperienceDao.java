package com.dbms.project.dao;

import com.dbms.project.model.WorkExperience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WorkExperienceDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public WorkExperienceDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int insertWorkExperience(WorkExperience workExperience) {
        final String sql = "INSERT INTO workExperience(employeeId, designation, joiningDate, leavingDate) VALUES(?, ?, ?, ?)";
        return jdbcTemplate.update(sql, workExperience.getEmployeeId(), workExperience.getDesignation(), workExperience.getJoiningDate(), workExperience.getLeavingDate());
    }

    public List<WorkExperience> getAllWorkExperiences() {
        final String sql = "SELECT * from workExperience";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(WorkExperience.class));
    }

    public WorkExperience getWorkExperienceById(int id) {
        final String sql = "SELECT * from workExperience WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[] {id}, new BeanPropertyRowMapper<>(WorkExperience.class));
    }

    public int deleteWorkExperience(int id) {
        final String sql = "DELETE FROM workExperience WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

    public int updateWorkExperience(int id, WorkExperience workExperience) {
        final String sql = "UPDATE workExperience SET employeeId = ?, designation = ?, joiningDate = ?, leavingDate = ? WHERE id = ?";
        return jdbcTemplate.update(sql, workExperience.getEmployeeId(), workExperience.getDesignation(), workExperience.getJoiningDate(), workExperience.getLeavingDate(), id);
    }
}
