package com.dbms.project.api;

import com.dbms.project.model.Transaction;
import com.dbms.project.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/transactions")
@Controller
public class TransactionController {
    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    @ResponseBody
    public void addTransaction(@RequestBody Transaction transaction) {
        transactionService.insertTransaction(transaction);
    }

    @GetMapping
    @ResponseBody
    public List<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    @DeleteMapping(path="{id}")
    @ResponseBody
    public void deleteTransaction(@PathVariable("id") int id) {
        transactionService.deleteTransaction(id);
    }

    @GetMapping(path="{id}")
    @ResponseBody
    public Transaction getTransactionById(@PathVariable("id") int id) {
        return transactionService.getTransactionById(id);
    }

    @PutMapping(path="{id}")
    @ResponseBody
    public void updateTransaction(@PathVariable("id") int id, @RequestBody Transaction transaction) {
        transactionService.updateTransaction(id, transaction);
    }
}
