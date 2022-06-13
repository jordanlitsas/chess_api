package com.spendingTracker.category;
import com.spendingTracker.user.CustomUser;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoryController {

    private final CategoryRepository repository;

    CategoryController(CategoryRepository repository) {
        this.repository = repository;
    }
    private static final Logger log = LoggerFactory.getLogger(CategoryController.class);

    @GetMapping("/category")
    @CrossOrigin(origins = {"https://expense-tracker-mobile.herokuapp.com/", "http://localhost:3000"})
    List<Category> all() {
        return repository.findAll();
    }

    @GetMapping("/category/{userId}")
    @CrossOrigin(origins = {"https://expense-tracker-mobile.herokuapp.com/", "http://localhost:3000"})
    List<Category> categoryNamesByUserId(@PathVariable String userId){
        List<Category> categories = repository.findAll();
        List<Category> returnCategories = new ArrayList<Category>();

        for (int i = 0; i < categories.size(); i++){
            if (categories.get(i).getUserId().equals(Long.parseLong(userId))){
                Category tempCategory = new Category();
                tempCategory.setName(categories.get(i).getName());
                tempCategory.setSevenDayLimit(categories.get(i).getSevenDayLimit());
                returnCategories.add(tempCategory);
            }
        }
        return returnCategories;
    }



    @PostMapping(path = "/category", consumes = "application/json")
    @CrossOrigin(origins = {"https://expense-tracker-mobile.herokuapp.com/", "http://localhost:3000"})
    Category newCategory(@RequestBody Category newCategory) {
        log.info(newCategory.toString());
        Category savedCategory = repository.save(newCategory);
        log.info(savedCategory.toString());
        return savedCategory;
    }

}
