package com.spring.springthymeleaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.springthymeleaf.entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
    CategoryEntity findOneByCode(String code);
}
