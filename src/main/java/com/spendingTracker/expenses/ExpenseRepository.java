package com.spendingTracker.expenses;

import com.spendingTracker.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {


}
