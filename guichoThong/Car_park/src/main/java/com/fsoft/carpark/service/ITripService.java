package com.fsoft.carpark.service;

import com.fsoft.carpark.dto.TripDto;
import com.fsoft.carpark.model.Trip;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface ITripService {
    // get all trips
    ResponseEntity<List<TripDto>> getAllTrips();

    // get trip by id
    ResponseEntity<TripDto> getTripById(Long id);

    // add a new trip
    ResponseEntity<Trip> addNewTrip(TripDto tripDto);

    //delete trip by id
    ResponseEntity<Map<String, Boolean>> deleteTripById(Long id);

    //convert Entity to DTO
    TripDto mapToDto(Trip trip);

    //convert DTO to Entity
    Trip mapToEntity(TripDto tripDto);
}
