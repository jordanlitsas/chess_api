package com.spendingTracker.expenses;

import com.spendingTracker.category.Category;
import com.spendingTracker.category.CategoryController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ExpenseController {

    private final ExpenseRepository repository;

    public ExpenseController(ExpenseRepository repository) {
        this.repository = repository;
    }
    private static final Logger log = LoggerFactory.getLogger(ExpenseController.class);


}
