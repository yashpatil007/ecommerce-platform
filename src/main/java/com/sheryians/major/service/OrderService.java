package com.sheryians.major.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sheryians.major.model.Order;
import com.sheryians.major.repository.OrderRepo;

@Service
public class OrderService {
	

    private final OrderRepo orderRepository;

    @Autowired
    public OrderService(OrderRepo orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }
}
