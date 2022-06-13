package com.spendingTracker;
import com.spendingTracker.category.Category;
import com.spendingTracker.category.CategoryRepository;
import com.spendingTracker.spendingItem.SpendingItem;
import com.spendingTracker.spendingItem.SpendingItemRepository;
import com.spendingTracker.user.CustomUser;
import com.spendingTracker.user.CustomUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(CustomUserRepository customUserRepository, CategoryRepository categoryRepository, SpendingItemRepository spendingItemRepository) {
        CustomUser user = new CustomUser("UzkUdIoDOMX0YD33jGGwkEe4b333");
//        Category category = new Category(1L, "cafe", 20.00);
//        SpendingItem spendingItem = new SpendingItem(1L, "cafe", 10.00, new Date());
        return args -> {
            log.info("Preloading " + customUserRepository.save(user));
//            log.info("Preloading " + categoryRepository.save(category));
//            log.info("Preloading " + spendingItemRepository.save(spendingItem));

        };
    }

}