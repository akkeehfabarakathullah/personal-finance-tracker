package com.example.Final.Service;
import com.example.Final.Repo.CategoryRepository;
import com.example.Final.Repo.TransactionRepository;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {
    private final TransactionRepository transactionRepository;

    public DashboardService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public TransactionRepository getTransactionRepository() {
        return transactionRepository;

    }
    private CategoryRepository categoryRepository;
    public void DashboardService(CategoryRepository categoryRepository) {

    }
    public CategoryRepository getCategoryRepository() {
        return categoryRepository;

    }
    public Object getRecentTransactions(int i) {
        return null;
    }

    public Object getTotalIncome() {
        return null;
    }

    public Object getTotalExpenses() {
        return null;
    }
}
