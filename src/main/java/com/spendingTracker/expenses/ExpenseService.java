package com.spendingTracker.expenses;

import com.spendingTracker.category.Category;
import com.spendingTracker.category.CategoryRepository;
import com.spendingTracker.spendingItem.SpendingItem;
import com.spendingTracker.spendingItem.SpendingItemRepository;

import java.util.ArrayList;
import java.util.List;

public class ExpenseService {
    private final SpendingItemRepository spendingItemRepository;
    private final CategoryRepository categoryRepository;

    public ExpenseService(SpendingItemRepository spendingItemRepository, CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
        this.spendingItemRepository = spendingItemRepository;
    }

    public List<Category> getCategoriesWithUserId(Long userId){
        List<Category> categories = new ArrayList<>();
        List<Category> allCategories = categoryRepository.findAll();
        for (int i = 0; i < allCategories.size(); i++){
            if (allCategories.get(i).getUserId().equals(userId)){
                Category tempCategory = new Category();
                tempCategory.setName(allCategories.get(i).getName());
                tempCategory.setSevenDayLimit(allCategories.get(i).getSevenDayLimit());
                categories.add(tempCategory);
            }
        }
        return categories;
    }

    public List<SpendingItem> getSpendingItemsWithUserId(Long userId){
        List<SpendingItem> spendingItems = new ArrayList<>();
        List<SpendingItem> allSpendingItems = spendingItemRepository.findAll();
        for (int i = 0; i < allSpendingItems.size(); i++){
            if (allSpendingItems.get(i).getUserId().equals(userId)){
                SpendingItem tempSpendingItem = new SpendingItem();
                tempSpendingItem.setCategory(allSpendingItems.get(i).getCategory());
                tempSpendingItem.setAmountSpent(allSpendingItems.get(i).getAmountSpent());
                spendingItems.add(tempSpendingItem);
            }
        }
        return spendingItems;
    }
}
