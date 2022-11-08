package com.dbms.project.dao;

import com.dbms.project.model.Transaction;
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
public class TransactionDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TransactionDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int insertTransaction(Transaction transaction) {
        final String sql = "INSERT INTO transaction(bankBranch, accountNumber, amount, mode, verificationStatus, dateOfTransaction, bankName) VALUES(?, ?, ?, ?, ?, ?, ?)";
        KeyHolder keyholder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, transaction.getBankBranch());
            ps.setInt(3, transaction.getAccountNumber());
            ps.setInt(4, transaction.getAmount());
            ps.setString(5, transaction.getMode());
            ps.setString(6, transaction.getVerificationStatus());
            ps.setDate(7, transaction.getDateOfTransaction());
            ps.setString(8, transaction.getBankName());

            return ps;
        }, keyholder);
        int id = keyholder.getKey().intValue();

        transaction.setId(id);
        return id;
    }

    public List<Transaction> getAllTransactions() {
        final String sql = "SELECT * from transaction";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Transaction.class));
    }

    public Transaction getTransactionById(int id) {
        final String sql = "SELECT * from transaction WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[] {id}, new BeanPropertyRowMapper<>(Transaction.class));
    }

    public int deleteTransaction(int id) {
        final String sql = "DELETE FROM transaction WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

    public int updateTransaction(int id, Transaction transaction) {
        final String sql = "UPDATE transaction SET bankBranch = ?, accountNumber = ?, amount = ?, mode = ?, VerificationStatus = ?, DateOfTransaction = ?, BankName = ? WHERE id = ?";
        return jdbcTemplate.update(sql, transaction.getBankBranch(), transaction.getAccountNumber(), transaction.getAmount(), transaction.getMode(), transaction.getVerificationStatus(), transaction.getDateOfTransaction(), transaction.getBankName(), id);
    }
}
