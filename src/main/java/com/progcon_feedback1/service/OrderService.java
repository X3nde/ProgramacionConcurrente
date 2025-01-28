package com.progcon_feedback1.service;

import com.progcon_feedback1.model.Order;
import com.progcon_feedback1.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Transactional
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    @Transactional(readOnly = true)
    public Iterable<Order> findAllOrders() {
        return orderRepository.findAll();
    }

    @Transactional(rollbackFor = Exception.class)
    public void updateOrder(Order order) throws Exception {
        orderRepository.save(order);
        if (someConditionFails()) {
            throw new Exception("Simulated error");
        }
    }

    private boolean someConditionFails() {
        return true;
    }
}
