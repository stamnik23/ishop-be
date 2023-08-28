package com.eq.ishop.controllers;

import com.eq.ishop.model.OrderHistory;
import com.eq.ishop.service.OrderHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/orderhistory")
public class OrderHistoryController {
    @Autowired
    private OrderHistoryService orderHistoryService;


    @GetMapping("/user/{userId}")
    public ResponseEntity<OrderHistory> getOrderHistoryByUserId(@PathVariable Long userId) {
        OrderHistory orderHistory = orderHistoryService.getOrderHistoryByUserId(userId);
        return ResponseEntity.ok(orderHistory);
    }
}