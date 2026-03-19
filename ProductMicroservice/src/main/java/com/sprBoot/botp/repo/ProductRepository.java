package com.sprBoot.botp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sprBoot.botp.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}