package com.spendingTracker.spendingItem;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

@RestController
public class SpendingItemController {

    private final SpendingItemRepository repository;
    private static final Logger log = LoggerFactory.getLogger(SpendingItemController.class);

    SpendingItemController(SpendingItemRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/spend")
    List<SpendingItem> all() {
        return repository.findAll();
    }

    @PostMapping(path = "/spend", consumes = "application/json")
    @CrossOrigin("https://expense-tracker-mobile.herokuapp.com/")
    SpendingItem spendingItem(@RequestBody SpendingItem spendingItem) {
        log.info(spendingItem.toString());
        return repository.save(spendingItem);
    }

}
