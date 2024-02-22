package com.example.TeamViewerChallenge.repository;

import com.example.TeamViewerChallenge.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
