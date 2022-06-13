package com.spendingTracker.expenses;

import com.spendingTracker.category.Category;
import com.spendingTracker.category.CategoryRepository;
import com.spendingTracker.spendingItem.SpendingItem;
import com.spendingTracker.spendingItem.SpendingItemRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController

public class ExpenseController {

    private ExpenseService expenseService;

    public ExpenseController(SpendingItemRepository spendingItemRepository, CategoryRepository categoryRepository) {
        this.expenseService = new ExpenseService(spendingItemRepository, categoryRepository);
    }

    @GetMapping("/expenses/{userId}")
    @CrossOrigin(origins = {"https://expense-tracker-mobile.herokuapp.com/", "http://localhost:3000"})
    List<Category> withUserId(@PathVariable String userId) {
       List<Expense> expenses = new ArrayList<>();
       List<Category> categories = expenseService.getCategoriesWithUserId(Long.parseLong(userId));
       Expense expense = new Expense(100.00, 50.00, "demo");
       expenses.add(expense);
       return categories;
    }

}
