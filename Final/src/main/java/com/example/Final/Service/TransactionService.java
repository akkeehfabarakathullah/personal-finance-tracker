package com.example.Final.Service;

import com.example.Final.Entities.Category;
import com.example.Final.Entities.Transaction;
import com.example.Final.Repo.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;



@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }
    public void saveTransaction(Transaction transaction) {
        transactionRepository.save(transaction);
    }
    public void deleteTransaction(long id) {
        transactionRepository.deleteById(id);
    }
    public Transaction getTransactionById(long id) {
        return transactionRepository.findById(id).orElse(null);
    }

    public List<Transaction> getTransactions(Map<String, String> params) {
        return null;
    }

    public Object getAllCategories() {
        return null;
    }
}
