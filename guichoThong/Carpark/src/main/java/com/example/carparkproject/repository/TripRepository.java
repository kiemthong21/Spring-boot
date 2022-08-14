package com.example.carparkproject.repository;

import com.example.carparkproject.dto.TripDTO;
import com.example.carparkproject.entity.Trip;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {
    Trip findTripByTripId(Long id);


    @Query("SELECT t FROM Trip t WHERE (:destination is null or t.destination like %:destination%)" +
            "AND (:departureTime is null or t.departureTime like %:departureTime%)" +
            "AND (:driver is null or t.driver like %:driver%)" +
            "AND (:carType is null or t.carType like %:carType%)" +
            "AND (:bookedTicketNumber is null or t.maximumOnlineTicketNumberTemp like %:bookedTicketNumber%)" +
            "AND (:destination is null or t.destination like %:destination%)")
    Page<Trip> getListTrip(@Param("destination") String destination,
                              @Param("departureTime") String departureTime,
                              @Param("driver") String driver,
                              @Param("carType") String carType,
                              @Param("bookedTicketNumber") String bookedTicketNumber,
                              Pageable pageable);

}
