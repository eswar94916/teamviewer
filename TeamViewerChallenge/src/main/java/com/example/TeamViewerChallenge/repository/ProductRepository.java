package com.example.TeamViewerChallenge.repository;

import com.example.TeamViewerChallenge.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
