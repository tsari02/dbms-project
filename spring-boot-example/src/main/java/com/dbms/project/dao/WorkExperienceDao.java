package com.dbms.project.dao;

import com.dbms.project.model.LeavesAndSalaries;
import com.dbms.project.model.WorkExperience;
import com.dbms.project.service.WorkExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.sql.PreparedStatement;
import java.sql.Statement;
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
        KeyHolder keyholder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, workExperience.getEmployeeId());
            ps.setString(2, workExperience.getDesignation());
            ps.setDate(3, workExperience.getJoiningDate());
            ps.setDate(4, workExperience.getLeavingDate());


            return ps;
        }, keyholder);
        int id = keyholder.getKey().intValue();

        workExperience.setId(id);
        return id;
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
