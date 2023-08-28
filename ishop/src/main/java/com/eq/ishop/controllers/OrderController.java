package com.eq.ishop.controllers;

import com.eq.ishop.dto.OrderRequest;
import com.eq.ishop.model.ApiResponse;
import com.eq.ishop.model.Order;
import com.eq.ishop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    // Endpoint to create a new order
    @PostMapping("/create")
    public ResponseEntity<?> createOrder(@RequestBody Order orderRequest) {
        orderService.createOrder(orderRequest);
        return ResponseEntity.ok(new ApiResponse("Order created successfully"));
    }

    // Endpoint to get an order by ID
    @GetMapping("/{orderId}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long orderId) {
        Order order = orderService.getOrderById(orderId);
        return ResponseEntity.ok(order);
    }
}
