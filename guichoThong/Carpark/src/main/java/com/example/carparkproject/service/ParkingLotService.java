package com.example.carparkproject.service;

import com.example.carparkproject.dto.ParkingLotDTO;
import com.example.carparkproject.entity.Car;
import com.example.carparkproject.entity.ParkingLot;
import com.example.carparkproject.mapper.ParkingLotMapper;
import com.example.carparkproject.repository.CarRepository;
import com.example.carparkproject.repository.ParkingLotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ParkingLotService {

    @Autowired
    private ParkingLotRepository parkingLotRepository;

    @Autowired
    private ParkingLotMapper parkingLotMapper;

    @Autowired
    private CarRepository carRepository;


    public Page<ParkingLotDTO> getListParkingLots(String parkName, String parkPlace, String parkArea, String parkPrice, String parkStatus, Pageable pageable) {
        return parkingLotRepository.getListParkingLots(parkName,parkPlace,parkArea,parkPrice,parkStatus,pageable).map(parkingLot -> parkingLotMapper.toDto(parkingLot));
    }

    public ParkingLotDTO getParkingLotDetail(Long id) {
        ParkingLot parkingLot = parkingLotRepository.findParkingLotByParkId(id);
        if(parkingLot == null){
            throw new RuntimeException("This id doesn't exist");
        }
        return parkingLotMapper.toDto(parkingLot);
    }


    public void createParkingLot(ParkingLotDTO parkingLotDTO) {
        parkingLotDTO.setParkId(null);
        ParkingLot parkingLot = parkingLotMapper.toEntity(parkingLotDTO);
        parkingLotRepository.save(parkingLot);
    }


    public void updateParkingLot(ParkingLotDTO parkingLotDTO, Long id) {
        parkingLotDTO.setParkId(id);
        ParkingLot parkingLot = parkingLotMapper.toEntity(parkingLotDTO);
        parkingLotRepository.save(parkingLot);
    }

    public void deleteParkingLot(Long id) {
        ParkingLot parkingLot = parkingLotRepository.findParkingLotByParkId(id);
        if(parkingLot == null){
            throw new RuntimeException("This id doesn't exist");
        }

        List<Car> cars = carRepository.findAllByParkId(id);
        if(!CollectionUtils.isEmpty(cars)){
            throw new RuntimeException("This parkingLot have been used in some object");
        }
        parkingLotRepository.delete(parkingLot);
    }
}
