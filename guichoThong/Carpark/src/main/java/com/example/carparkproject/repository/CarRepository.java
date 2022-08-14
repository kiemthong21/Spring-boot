package com.example.carparkproject.repository;

import com.example.carparkproject.dto.CarDTO;
import com.example.carparkproject.entity.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, String> {


    @Query("SELECT new com.example.carparkproject.dto.CarDTO(c.licensePlate,c.color,c.carType,c.company,p.parkName) " +
            "FROM Car c LEFT JOIN ParkingLot p ON c.parkId = p.parkId " +
            "WHERE (:licensePlate is null or c.licensePlate like %:licensePlate%)" +
            "AND (:carType is null or c.carType like %:carType%) " +
            "AND (:carColor is null or c.color like %:carColor%) " +
            "AND (:company is null or c.company like %:company%) " +
            "AND (p.parkName is null or p.parkName like %:parkingLot%) ")
    Page<CarDTO> getListCar(@Param("licensePlate") String licensePlate,
                            @Param("carType") String carType,
                            @Param("carColor") String carColor,
                            @Param("company") String company,
                            @Param("parkingLot") String parkingLot,
                            Pageable pageable);

    @Query("SELECT new com.example.carparkproject.dto.CarDTO(c.licensePlate,c.color,c.carType,c.company,p.parkName) " +
            "FROM Car c LEFT JOIN ParkingLot p ON c.parkId = p.parkId " +
            "WHERE c.licensePlate = :licensePlate")
    CarDTO getCarWithParkingName(@Param("licensePlate") String licensePlate);

    Car findCarByLicensePlate(String licensePlate);

    List<Car> findAllByParkId(Long parkid);
}
