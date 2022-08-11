package com.spring.springthymeleaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spring.springthymeleaf.entity.NewEntity;

public interface NewRepository extends JpaRepository<NewEntity, Long> {
    @Query(value = "Select * from news where title = :title", nativeQuery = true)
    NewEntity findNewByTitle(@Param("title") String title);

}
