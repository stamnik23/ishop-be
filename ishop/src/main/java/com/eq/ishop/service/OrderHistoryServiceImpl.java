package com.eq.ishop.service;

import com.eq.ishop.model.OrderHistory;
import com.eq.ishop.repository.OrderHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderHistoryServiceImpl implements OrderHistoryService {

    private final OrderHistoryRepository orderHistoryRepository;

    @Autowired
    public OrderHistoryServiceImpl(OrderHistoryRepository orderHistoryRepository) {
        this.orderHistoryRepository = orderHistoryRepository;
    }

    @Override
    public OrderHistory getOrderHistoryByUserId(Long userId) {
         return orderHistoryRepository.findByUserId(userId);
    }

    @Override
    public OrderHistory saveOrderHistory(OrderHistory orderHistory) {
        return orderHistoryRepository.save(orderHistory);
    }
}