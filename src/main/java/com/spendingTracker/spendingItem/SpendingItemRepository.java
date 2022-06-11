package com.spendingTracker.spendingItem;

import com.spendingTracker.spendingItem.SpendingItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

public interface SpendingItemRepository extends JpaRepository<SpendingItem, Long> {
}
