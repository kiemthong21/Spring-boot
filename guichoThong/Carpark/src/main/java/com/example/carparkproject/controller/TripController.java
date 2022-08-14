package com.example.carparkproject.controller;

import com.example.carparkproject.dto.TripDTO;
import com.example.carparkproject.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("api/trips")
public class TripController {
    @Autowired
    private TripService tripService;

    @PreAuthorize("hasAuthority(\"" + "administration" + "\")")
    @GetMapping("/get-list-trips")
    public ResponseEntity<Page<TripDTO>> getListTrip(@RequestParam(required = false, defaultValue = "") String destination,
                                                     @RequestParam(required = false, defaultValue = "") String departureTime,
                                                     @RequestParam(required = false, defaultValue = "") String driver,
                                                     @RequestParam(required = false, defaultValue = "") String carType,
                                                     @RequestParam(required = false, defaultValue = "") String bookedTicketNumber,
                                                     Pageable pageable) {
        return ResponseEntity.ok().body(tripService.getListTrip(destination, departureTime, driver, carType, bookedTicketNumber, pageable));
    }

    @PreAuthorize("hasAuthority(\"" + "administration" + "\")")
    @GetMapping("/{id}")
    public ResponseEntity<TripDTO> getTripDetail(@NotNull @PathVariable Long id) {
        return ResponseEntity.ok().body(tripService.getTripDetail(id));
    }

    @PreAuthorize("hasAuthority(\"" + "administration" + "\")")
    @PostMapping()
    public ResponseEntity<Void> createTrip(@NotNull @Validated(TripDTO.Create.class) @RequestBody TripDTO tripDTO) {
        tripService.createTrip(tripDTO);
        return ResponseEntity.ok().build();
    }

    @PreAuthorize("hasAuthority(\"" + "administration" + "\")")
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateTrip(@NotNull @Validated(TripDTO.Create.class) @RequestBody TripDTO tripDTO,
                                           @NotNull @PathVariable Long id) {
        tripService.updateTrip(tripDTO, id);
        return ResponseEntity.ok().build();
    }

    @PreAuthorize("hasAuthority(\"" + "administration" + "\")")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTrip(@NotNull @PathVariable Long id) {
        tripService.deleteTrip(id);
        return ResponseEntity.ok().build();
    }
}
