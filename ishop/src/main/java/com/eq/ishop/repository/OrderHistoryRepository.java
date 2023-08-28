package com.eq.ishop.repository;

import com.eq.ishop.model.OrderHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderHistoryRepository extends JpaRepository<OrderHistory, Long> {

    OrderHistory findByUserId(long id);
    OrderHistory save(OrderHistory Order);
}
