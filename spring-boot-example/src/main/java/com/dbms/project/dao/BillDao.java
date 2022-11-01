package com.dbms.project.dao;

import com.dbms.project.model.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BillDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BillDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int insertBill(Bill bill) {
        final String sql = "INSERT INTO bill(gstNumber, amount, discount, netAmount) VALUES(?, ?, ?, ?)";
        return jdbcTemplate.update(sql, bill.getGstNumber(), bill.getAmount(), bill.getDiscount(), bill.getNetAmount());
    }

    public List<Bill> getAllBills() {
        final String sql = "SELECT * from bill";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Bill.class));
    }

    public Bill getBillById(int id) {
        final String sql = "SELECT * from bill WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[] {id}, new BeanPropertyRowMapper<>(Bill.class));
    }

    public int deleteBill(int id) {
        final String sql = "DELETE FROM bill WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

    public int updateBill(int id, Bill bill) {
        final String sql = "UPDATE bill SET gstNumber = ?, amount = ?, discount = ?, netAmount = ? WHERE id = ?";
        return jdbcTemplate.update(sql, bill.getGstNumber(), bill.getAmount(), bill.getDiscount(), bill.getNetAmount(), id);
    }
}
