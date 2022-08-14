package com.fsoft.carpark.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fsoft.carpark.model.BookingOffice;

@Repository
public interface BookingOfficeRepository extends JpaRepository<BookingOffice, Long> {
}