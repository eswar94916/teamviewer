package com.example.TeamViewerChallenge.service;

import com.example.TeamViewerChallenge.model.OrderItem;
import com.example.TeamViewerChallenge.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    public List<OrderItem> getAllOrderItems() {
        return orderItemRepository.findAll();
    }

    public OrderItem getOrderItemById(Long id) {
        return orderItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("OrderItem not found with id: " + id));
    }

    public OrderItem createOrderItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    public OrderItem updateOrderItem(Long id, OrderItem orderItem) {
        OrderItem existingOrderItem = getOrderItemById(id);
        existingOrderItem.setOrder(orderItem.getOrder());
        existingOrderItem.setProduct(orderItem.getProduct());
        existingOrderItem.setQuantity(orderItem.getQuantity());
        existingOrderItem.setPrice(orderItem.getPrice());
        existingOrderItem.setTotalPrice(orderItem.getTotalPrice());
        return orderItemRepository.save(existingOrderItem);
    }

    public void deleteOrderItem(Long id) {
        orderItemRepository.deleteById(id);
    }
}
