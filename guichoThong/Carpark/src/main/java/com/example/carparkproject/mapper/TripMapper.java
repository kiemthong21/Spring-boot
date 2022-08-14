package com.example.carparkproject.mapper;

import com.example.carparkproject.dto.TripDTO;
import com.example.carparkproject.entity.Trip;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TripMapper extends EntityMapper<Trip, TripDTO>{

    Trip toEntity(TripDTO tripDTO);

    TripDTO toDto(Trip trip);
}
