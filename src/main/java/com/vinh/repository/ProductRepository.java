package com.vinh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vinh.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
