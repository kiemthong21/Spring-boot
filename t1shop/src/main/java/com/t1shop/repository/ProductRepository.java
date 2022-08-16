package com.t1shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.t1shop.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "select * from settings where setting_name like '%%' and groupby like '%%'", nativeQuery = true)
    List<Product> findByCondition(String search, String group);

}
