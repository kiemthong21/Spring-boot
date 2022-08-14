package com.example.carparkproject.mapper;

import com.example.carparkproject.dto.ParkingLotDTO;
import com.example.carparkproject.entity.ParkingLot;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ParkingLotMapper extends EntityMapper<ParkingLot, ParkingLotDTO>{

    ParkingLot toEntity(ParkingLotDTO parkingLotDTO);

    ParkingLotDTO toDto(ParkingLot parkingLot);
}
