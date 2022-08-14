package com.example.carparkproject.controller;

import com.example.carparkproject.dto.CarDTO;
import com.example.carparkproject.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("api/cars")
public class CarController {
    @Autowired
    private CarService carService;

    @PreAuthorize("hasAuthority(\"" + "administration" + "\")")
    @GetMapping("get-list-cars")
    public ResponseEntity<Page<CarDTO>> getListCar(@RequestParam(required = false, defaultValue = "") String licensePlate,
                                                   @RequestParam(required = false, defaultValue = "") String carType,
                                                   @RequestParam(required = false, defaultValue = "") String carColor,
                                                   @RequestParam(required = false, defaultValue = "") String company,
                                                   @RequestParam(required = false, defaultValue = "") String parkingLot,
                                                   Pageable pageable) {
        return ResponseEntity.ok().body(carService.getListCar(licensePlate, carType, carColor, company, parkingLot, pageable));
    }

    @PreAuthorize("hasAuthority(\"" + "administration" + "\")")
    @GetMapping("/{licensePlate}")
    public ResponseEntity<CarDTO> getCarDetail(@NotNull @PathVariable String licensePlate) {
        return ResponseEntity.ok().body(carService.getCarDetail(licensePlate));
    }

    @PreAuthorize("hasAuthority(\"" + "administration" + "\")")
    @PostMapping("")
    public ResponseEntity<Void> createCar(@NotNull @Validated(CarDTO.Create.class) CarDTO carDTO) {
        carService.createCar(carDTO);
        return ResponseEntity.ok().build();
    }

    @PreAuthorize("hasAuthority(\"" + "administration" + "\")")
    @PutMapping("/{licensePlate}")
    public ResponseEntity<Void> updateCar(@NotNull @Validated(CarDTO.Update.class) CarDTO carDTO,
                                          @NotNull @PathVariable String licensePlate) {
        carService.updateCar(carDTO, licensePlate);
        return ResponseEntity.ok().build();
    }

    @PreAuthorize("hasAuthority(\"" + "administration" + "\")")
    @DeleteMapping("/{licensePlate}")
    public ResponseEntity<Void> deleteCar(@NotNull @PathVariable String licensePlate) {
        carService.deleteCar(licensePlate);
        return ResponseEntity.ok().build();

    }
}
