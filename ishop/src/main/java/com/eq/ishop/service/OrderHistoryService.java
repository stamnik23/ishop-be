package com.eq.ishop.service;

import com.eq.ishop.model.OrderHistory;

import java.util.List;

public interface OrderHistoryService {
    OrderHistory getOrderHistoryByUserId(Long userId);
    OrderHistory saveOrderHistory(OrderHistory orderHistory);
}
