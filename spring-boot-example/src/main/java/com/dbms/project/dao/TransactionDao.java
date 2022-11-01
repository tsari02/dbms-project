package com.dbms.project.dao;

import com.dbms.project.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TransactionDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TransactionDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int insertTransaction(Transaction transaction) {
        final String sql = "INSERT INTO transaction(bankBranch, productType, accountNumber, amount, mode, verificationStatus, dateOfTransaction, bankName) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, transaction.getBankBranch(), transaction.getProductType(), transaction.getAccountNumber(), transaction.getAmount(), transaction.getMode(), transaction.getVerificationStatus(), transaction.getDateOfTransaction(), transaction.getBankName());
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
        final String sql = "UPDATE transaction SET bankBranch = ?, productType = ?, accountNumber = ?, amount = ?, mode = ?, VerificationStatus = ?, DateOfTransaction = ?, BankName = ? WHERE id = ?";
        return jdbcTemplate.update(sql, transaction.getBankBranch(), transaction.getProductType(), transaction.getAccountNumber(), transaction.getAmount(), transaction.getMode(), transaction.getVerificationStatus(), transaction.getDateOfTransaction(), transaction.getBankName(), id);
    }
}
