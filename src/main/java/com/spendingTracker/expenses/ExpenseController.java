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
    List<Expense> withUserId(@PathVariable String userId) {
       List<Expense> expenses = new ArrayList<>();
       List<Category> categories = expenseService.getCategoriesWithUserId(Long.parseLong(userId));
       List<SpendingItem> spendingItems = expenseService.getSpendingItemsWithUserId((Long.parseLong(userId)));

       for (int i = 0; i < categories.size(); i++){
           Expense expense =  new Expense();
           expense.setCategory(categories.get(i).getName());
           expense.setWeeklyLimit(categories.get(i).getSevenDayLimit());
           expense.setExpenseType(categories.get(i).getExpenseType());
           expenses.add(expense);
       }

       for (int i = 0; i < spendingItems.size(); i++){
           for (int j = 0; j < expenses.size(); j++){
               if (spendingItems.get(i).getCategory().equals(expenses.get(j).getCategory())){
                   expenses.get(j).addPurchase(spendingItems.get(i).getAmountSpent());
               }
           }
       }
       return expenses;
    }

}
