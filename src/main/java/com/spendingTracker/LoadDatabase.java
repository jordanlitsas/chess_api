package com.spendingTracker;
import com.spendingTracker.category.Category;
import com.spendingTracker.category.CategoryRepository;
import com.spendingTracker.user.CustomUser;
import com.spendingTracker.user.CustomUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(CustomUserRepository customUserRepository, CategoryRepository categoryRepository) {
        return args -> {
            log.info("Preloading " + customUserRepository.save(new CustomUser("UzkUdIoDOMX0YD33jGGwkEe4b333")));
            log.info("Preloading " + categoryRepository.save(new Category("1", "cafe", 20.00)));

        };
    }

}