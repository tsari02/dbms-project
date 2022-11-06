package com.dbms.project.dao;

import com.dbms.project.model.LeavesAndSalaries;
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
public class LeavesAndSalariesDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public LeavesAndSalariesDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int insertLeavesAndSalaries(LeavesAndSalaries leavesAndSalaries) {
        final String sql = "INSERT INTO leavesAndSalaries(leavesTaken, leavesAllowed, year, month, overtime, bonus, penalty, employeeId) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        KeyHolder keyholder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, leavesAndSalaries.getLeavesTaken());
            ps.setInt(2, leavesAndSalaries.getLeavesAllowed());
            ps.setInt(3, leavesAndSalaries.getYear());
            ps.setInt(4, leavesAndSalaries.getMonth());
            ps.setInt(5, leavesAndSalaries.getOvertime());
            ps.setInt(6, leavesAndSalaries.getBonus());
            ps.setInt(7, leavesAndSalaries.getPenalty());
            ps.setInt(8, leavesAndSalaries.getEmployeeId());

            return ps;
        }, keyholder);
        int id = keyholder.getKey().intValue();

        leavesAndSalaries.setId(id);
        return id;
    }

    public List<LeavesAndSalaries> getAllLeavesAndSalaries() {
        final String sql = "SELECT * from leavesAndSalaries";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(LeavesAndSalaries.class));
    }

    public LeavesAndSalaries getLeavesAndSalariesById(int id) {
        final String sql = "SELECT * from leavesAndSalaries WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[] {id}, new BeanPropertyRowMapper<>(LeavesAndSalaries.class));
    }

    public int deleteLeavesAndSalaries(int id) {
        final String sql = "DELETE FROM leavesAndSalaries WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

    public int updateLeavesAndSalaries(int id, LeavesAndSalaries leavesAndSalaries) {
        final String sql = "UPDATE leavesAndSalaries SET leavesTaken = ?, leavesAllowed = ?, year = ?, month = ?, overtimes = ?, bonus = ?, penalty = ?, employeeId = ? WHERE id = ?";
        return jdbcTemplate.update(sql, leavesAndSalaries.getLeavesTaken(), leavesAndSalaries.getLeavesAllowed(), leavesAndSalaries.getYear(), leavesAndSalaries.getMonth(), leavesAndSalaries.getOvertime(), leavesAndSalaries.getBonus(), leavesAndSalaries.getPenalty(), leavesAndSalaries.getEmployeeId(), id);
    }
}
