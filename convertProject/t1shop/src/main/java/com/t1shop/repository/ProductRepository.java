package com.t1shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.t1shop.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
    
}
