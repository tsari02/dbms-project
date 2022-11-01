package com.dbms.project.service;

import com.dbms.project.dao.SupplierDao;
import com.dbms.project.model.Supplier;
import com.dbms.project.model.Transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    private final TransactionDao transactionDao;
    
    @Autowired
    public TransactionService(TransactionDao transactionDao) {
        this.transactionDao = transactionDao;
    }

    public int insertTransaction(Transaction transaction) {
        return transactionDao.insertTransaction(transaction);
    }

    public List<Transaction> getAllTransactions() {
        return transactionDao.getAllTransactions();
    }

    public Transaction getTransactionById(int id) {
        return transactionDao.getTransactionById(id);
    }

    public int deleteTransaction(int id) {
        return transactionDao.deleteTransaction(id);
    }

    public int updateTransaction(int id, Transaction transaction) {
        return transactionDao.updateSupplier(id, transaction);
    }
}
