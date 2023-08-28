package com.eq.ishop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.eq.ishop.model.Order;
import com.eq.ishop.repository.OrderRepository;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    // Create a new order
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    // Get all orders
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    // Get an order by ID
    public Order getOrderById(Long orderId) {
        return orderRepository.findById(orderId);
    }

    // Delete an order by ID
    public void deleteOrder(Long orderId) {
        orderRepository.deleteById(orderId);
    }

    // Update an existing order
    public Order updateOrder(Order order) {
        return orderRepository.save(order);
    }
}