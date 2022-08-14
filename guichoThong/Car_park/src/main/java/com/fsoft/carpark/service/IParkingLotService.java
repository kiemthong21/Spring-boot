package com.fsoft.carpark.service;

import com.fsoft.carpark.dto.ParkingLotDto;
import com.fsoft.carpark.model.ParkingLot;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface IParkingLotService {
    // get all parkingLots
    ResponseEntity<List<ParkingLotDto>> getAllParkingLots();

    // get parkingLot by id
    ResponseEntity<ParkingLotDto> getParkingLotById(Long id);

    // add a new parkingLot
    ResponseEntity<ParkingLot> addNewParkingLot(ParkingLotDto parkingLotDto);

    //delete parkingLot by id
    ResponseEntity<Map<String, Boolean>> deleteById(Long id);

    //convert Entity to DTO
    ParkingLotDto mapToDto(ParkingLot parkingLot);

    //convert DTO to Entity
    ParkingLot mapToEntity(ParkingLotDto parkingLotDto);
}
