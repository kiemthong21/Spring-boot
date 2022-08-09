package com.spring.springthymeleaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.springthymeleaf.entity.NewEntity;

public interface NewRepository extends JpaRepository<NewEntity, Long> {

}
