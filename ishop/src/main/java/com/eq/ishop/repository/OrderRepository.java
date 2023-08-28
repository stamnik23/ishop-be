package com.eq.ishop.repository;


import com.eq.ishop.model.Order;
import com.eq.ishop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

    Order findById(long id);
    void deleteById(long id);
    Order save(Order Order);
}
