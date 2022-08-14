package com.example.carparkproject.mapper;

import com.example.carparkproject.dto.CarDTO;
import com.example.carparkproject.entity.Car;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CarMapper extends EntityMapper<Car, CarDTO> {
    Car toEntity(CarDTO carDTO);

    CarDTO toDto(Car car);
}
