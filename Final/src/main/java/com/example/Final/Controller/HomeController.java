package com.example.Final.Controller;

import com.example.Final.Service.CategoryService;
import com.example.Final.Service.DashboardService;
import com.example.Final.Service.TransactionService;
import com.example.Final.Service.UserService;
import com.example.Final.Entities.Category;
import com.example.Final.Entities.Transaction;
import com.example.Final.Entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
public class HomeController {

    @Autowired
    private DashboardService dashboardService;

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private UserService userService;

    // Home Page
    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @PostMapping("/home")
    public String userHome(@ModelAttribute("user") User user, Model model) {
        model.addAttribute("user", user);
        return "home";
    }

//    // Dashboard Page
    @GetMapping("/new/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("totalIncome", dashboardService.getTotalIncome());
        model.addAttribute("totalExpenses", dashboardService.getTotalExpenses());
        model.addAttribute("recentTransactions", dashboardService.getRecentTransactions(5));
        model.addAttribute("categories", categoryService.getAllCategories());
        return "dashboard";
    }

    // Transaction Pages

    @GetMapping("/transactions/new")
    public String showTransactionForm(Model model) {
        model.addAttribute("transaction", new Transaction());
        model.addAttribute("categories", transactionService.getAllCategories()); // Fetch categories for the dropdown
        return "transaction-form";
    }

    @PostMapping("/transactions/save")
    public String saveTransaction(@Valid @ModelAttribute Transaction transaction, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "transaction-form";
        }
        transactionService.saveTransaction(transaction);
        redirectAttributes.addFlashAttribute("message", "Transaction saved successfully!");
        return "redirect:/transactions/history";
    }

    @GetMapping("/transactions/history")
    public String showTransactionHistory(@RequestParam Map<String, String> params, Model model) {
        // Fetch transactions based on filter parameters
        List<Transaction> transactions = transactionService.getTransactions(params);
        model.addAttribute("transactions", transactions);
        return "transaction-history";
    }


    //category page
    @GetMapping("/categories")
    public String listCategories(Model model) {
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("newCategory", new Category());
        return "categories";  // View name
    }

    @PostMapping("/save")
    public String saveCategory(@ModelAttribute Category category) {
        categoryService.saveCategory(category);
        return "redirect:/categories";
    }

    @PostMapping("/update")
    public String updateCategory(@ModelAttribute Category category) {
        categoryService.saveCategory(category);
        return "redirect:/categories";
    }

    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return "redirect:/categories";
    }

    @GetMapping("/edit/{id}")
    public String editCategory(@PathVariable Long id, Model model) {
        Optional<Category> category = categoryService.getCategoryById(id);
        if (category.isPresent()) {
            model.addAttribute("categoryToUpdate", category.get());
        }
        return "categories";  // Redirect to the categories view
    }

    // User Pages
    @GetMapping("/user/register")
    public String showRegisterPage(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping("/user/registerUser")
    public String registerUser(@Valid @ModelAttribute User user, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        userService.addUser(user);
        redirectAttributes.addFlashAttribute("message", "User registered successfully!");
        return "redirect:/user/login"; // Redirect to login page after successful registration
    }

    @GetMapping("/user/login")
    public String showLoginPage(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/register")
    public String registerUser(User user) {
        return "redirect:/user/login";
    }

}