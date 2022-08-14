package com.fsoft.carpark.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fsoft.carpark.model.Trip;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {
}