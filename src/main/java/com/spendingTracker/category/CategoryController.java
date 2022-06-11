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
    List<Category> all() {
        return repository.findAll();
    }

    @GetMapping("/category/{userId}")
    @CrossOrigin("http://localhost:3000")
    List<String> categoryNamesByUserId(@PathVariable String userId){
        List<Category> categories = repository.findAll();
        List<String> categoryNames = new ArrayList<String>();

        for (int i = 0; i < categories.size(); i++){
            if (categories.get(i).getUserId().equals(userId)){
                categoryNames.add(categories.get(i).getName());
            }
        }
        return categoryNames;
    }



    @PostMapping(path = "/category", consumes = "application/json")
    @CrossOrigin("http://localhost:3000")
    Category newCategory(@RequestBody Category newCategory) {
        log.info(newCategory.toString());
        return repository.save(newCategory);
    }

}
