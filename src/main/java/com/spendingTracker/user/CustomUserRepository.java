package com.spendingTracker.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

public interface CustomUserRepository extends JpaRepository<CustomUser, Long>{
}
