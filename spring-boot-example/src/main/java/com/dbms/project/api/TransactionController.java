package com.dbms.project.api;

import com.dbms.project.model.Transaction;
import com.dbms.project.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

// @RequestMapping("api/transactions")
@Controller
public class TransactionController {
    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping(path="/api/transactions")
    @ResponseBody
    public void addTransaction(@Valid @NotNull @RequestBody Transaction transaction) {
        transactionService.insertTransaction(transaction);
    }

    @GetMapping(path="/api/transactions")
    @ResponseBody
    public List<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    @PostMapping(path="/api/transactions/{id}/delete")
    @ResponseBody
    public void deleteTransaction(@PathVariable("id") int id) {
        transactionService.deleteTransaction(id);
    }

    @GetMapping(path="/api/transactions/{id}")
    @ResponseBody
    public Transaction getTransactionById(@PathVariable("id") int id) {
        return transactionService.getTransactionById(id);
    }

    @PostMapping(path="/api/transactions/{id}/edit")
    @ResponseBody
    public void updateTransaction(@PathVariable("id") int id, @Valid @NotNull @RequestBody Transaction transaction) {
        transactionService.updateTransaction(id, transaction);
    }
}
