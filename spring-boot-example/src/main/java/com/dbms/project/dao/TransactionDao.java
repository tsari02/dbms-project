package com.dbms.project.dao;

import com.dbms.project.model.Customer;
import com.dbms.project.model.Supplier;
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
        final String sql = "INSERT INTO Transaction(TransactionId,BankBranch,ProductType,AccountNumber,amount,mode,VerificationStatus,DateofTrans,BankName) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, transaction.getTransactionId(), transaction.getBankBranch(), transaction.getProductType(), transaction.getAccountNumber(), transaction.getAmount(), transaction.getMode(), transaction.getVerificationStatus(), transaction.getDateofTrans(), transaction.getBankName());
    }

    public List<Transaction> getAllTransactions() {
        final String sql = "SELECT * from Transaction";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Transaction.class));
    }

    public Supplier getTransactionById(int id) {
        final String sql = "SELECT * from Transaction WHERE TransactionId = ?";
        return jdbcTemplate.queryForObject(sql, new Object[] {id}, new BeanPropertyRowMapper<>(Supplier.class));
    }

    public int deleteTransaction(int id) {
        final String sql = "DELETE FROM Transaction WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

    public int updateTransaction(int id, Transaction transaction) {
        final String sql = "UPDATE Transaction SET TransactionId = ?, BankBranch = ?,ProductType = ?,AccountNumber = ?,amount = ?,mode = ?,VerificationStatus = ?,DateofTrans = ?,BankName = ?";
        return jdbcTemplate.update(sql, transaction.getTransactionId(), transaction.getBankBranch(), transaction.getProductType(), transaction.getAccountNumber(), transaction.getAmount(), transaction.getMode(), transaction.getVerificationStatus(), transaction.getDateofTrans(), transaction.getBankName());
    }
}
