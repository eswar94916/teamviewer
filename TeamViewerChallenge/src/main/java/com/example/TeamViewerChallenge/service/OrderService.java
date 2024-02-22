package com.example.TeamViewerChallenge.service;

import com.example.TeamViewerChallenge.model.Order;
import com.example.TeamViewerChallenge.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + id));
    }

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order updateOrder(Long id, Order order) {
        Order existingOrder = getOrderById(id);
        existingOrder.setCustomerName(order.getCustomerName());
        // Set other fields as needed
        return orderRepository.save(existingOrder);
    }

    public void deleteOrder(Long orderId) {
        // Check if the order exists
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        if (((Optional<?>) optionalOrder).isPresent()) {
            // If the order exists, delete it
            orderRepository.deleteById(orderId);
        }
    }
}
