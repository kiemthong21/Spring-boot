package com.example.carparkproject.service;

import com.example.carparkproject.dto.CarDTO;
import com.example.carparkproject.entity.Car;
import com.example.carparkproject.entity.ParkingLot;
import com.example.carparkproject.entity.Ticket;
import com.example.carparkproject.mapper.CarMapper;
import com.example.carparkproject.repository.CarRepository;
import com.example.carparkproject.repository.ParkingLotRepository;
import com.example.carparkproject.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CarService {
    @Autowired
    private CarRepository carRepository;

    @Autowired
    private CarMapper carMapper;

    @Autowired
    private ParkingLotRepository parkingLotRepository;

    @Autowired
    private TicketRepository ticketRepository;

    public Page<CarDTO> getListCar(String licensePlate, String carType, String carColor, String company, String parkingLot, Pageable pageable) {
        return carRepository.getListCar(licensePlate,carType,carColor,company,parkingLot,pageable);
    }

    public CarDTO getCarDetail(String licensePlate) {
        CarDTO carDTO = carRepository.getCarWithParkingName(licensePlate);
        if(carDTO == null){
            throw new RuntimeException("This car doesn't exist");
        }
        return carDTO;
    }

    public void createCar(CarDTO carDTO) {
        Car car = carRepository.findCarByLicensePlate(carDTO.getLicensePlate());
        if(car != null){
            throw new RuntimeException("This licensePlate is duplicate");
        }
        if(carDTO.getParkId() != null){
            ParkingLot parkingLot = parkingLotRepository.findParkingLotByParkId(carDTO.getParkId());
            if(parkingLot != null){
                throw new RuntimeException("This parking lot doesn't exist");
            }
        }
        Car newCar = carMapper.toEntity(carDTO);
        carRepository.save(newCar);
    }

    public void updateCar(CarDTO carDTO, String licensePlate) {
        carDTO.setLicensePlate(licensePlate);
        Car car = carRepository.findCarByLicensePlate(licensePlate);
        if(car == null){
            throw new RuntimeException("This car doesn't exist");
        }
        if(carDTO.getParkId() != null){
            ParkingLot parkingLot = parkingLotRepository.findParkingLotByParkId(carDTO.getParkId());
            if(parkingLot != null){
                throw new RuntimeException("This parking lot doesn't exist");
            }
        }
        Car newCar = carMapper.toEntity(carDTO);
        carRepository.save(newCar);
    }

    public void deleteCar(String licensePlate) {
        Car car = carRepository.findCarByLicensePlate(licensePlate);
        if(car == null){
            throw new RuntimeException("This car doesn't exist");
        }
        List<Ticket> tickets = ticketRepository.findAllByLicensePlate(car.getLicensePlate());
        if(!CollectionUtils.isEmpty(tickets)){
            throw new RuntimeException("This car have been used in some ticket");
        }
        carRepository.delete(car);
    }
}
