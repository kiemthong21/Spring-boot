package com.example.carparkproject.controller;

import com.example.carparkproject.dto.ParkingLotDTO;
import com.example.carparkproject.service.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("api/parking-lots")
public class ParkingLotController {

    @Autowired
    private ParkingLotService parkingLotService;

    @PreAuthorize("hasAuthority(\"" + "administration" + "\")")
    @GetMapping("/get-list-parking-lots")
    public ResponseEntity<Page<ParkingLotDTO>> getListParkingLots(@RequestParam(required = false, defaultValue = "") String parkName,
                                                                  @RequestParam(required = false, defaultValue = "") String parkPlace,
                                                                  @RequestParam(required = false, defaultValue = "") String parkArea,
                                                                  @RequestParam(required = false, defaultValue = "") String parkPrice,
                                                                  @RequestParam(required = false, defaultValue = "") String parkStatus,
                                                                  Pageable pageable){
        return ResponseEntity.ok().body(parkingLotService.getListParkingLots(parkName,parkPlace,parkArea,parkPrice,parkStatus,pageable));
    }

    @PreAuthorize("hasAuthority(\"" + "administration" + "\")")
    @GetMapping("/{id}")
    public ResponseEntity<ParkingLotDTO> getParkingLotDetail(@NotNull @PathVariable Long id){
        return ResponseEntity.ok().body(parkingLotService.getParkingLotDetail(id));
    }

    @PreAuthorize("hasAuthority(\"" + "administration" + "\")")
    @PostMapping("")
    public ResponseEntity<Void> createParkingLot(@NotNull @Validated(ParkingLotDTO.Create.class) @RequestBody ParkingLotDTO parkingLotDTO){
        parkingLotService.createParkingLot(parkingLotDTO);
        return ResponseEntity.ok().build();
    }

    @PreAuthorize("hasAuthority(\"" + "administration" + "\")")
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateParkingLot(@NotNull @Validated(ParkingLotDTO.Update.class) @RequestBody ParkingLotDTO parkingLotDTO,
                                                 @NotNull @PathVariable Long id){
        parkingLotService.updateParkingLot(parkingLotDTO,id);
        return ResponseEntity.ok().build();
    }

    @PreAuthorize("hasAuthority(\"" + "administration" + "\")")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteParkingLot(@NotNull @PathVariable Long id){
        parkingLotService.deleteParkingLot(id);
        return ResponseEntity.ok().build();
    }

}
