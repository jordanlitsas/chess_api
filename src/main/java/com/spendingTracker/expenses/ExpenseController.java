package com.spendingTracker.expenses;

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
    private final SpendingItemRepository spendingItemRepository;
    private final CategoryRepository categoryRepository;

    public ExpenseController(SpendingItemRepository spendingItemRepository, CategoryRepository categoryRepository) {
        this.spendingItemRepository = spendingItemRepository;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/expenses/{userId}")
    @CrossOrigin(origins = {"https://expense-tracker-mobile.herokuapp.com/", "http://localhost:3000"})
    List<Expense> withUserId(@PathVariable String userId) {
       List<Expense> expenses = new ArrayList<>();
       Expense expense = new Expense(100.00, 50.00, "demo");
       return expenses;
    }

}
