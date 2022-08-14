package com.example.carparkproject.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ParkingLotDTO {

    private Long parkId;

    @NotNull(groups = {ParkingLotDTO.Create.class,ParkingLotDTO.Update.class})
    private Long parkArea;

    @NotBlank(groups = {ParkingLotDTO.Create.class,ParkingLotDTO.Update.class})
    @Length(max = 50, groups = {ParkingLotDTO.Create.class,ParkingLotDTO.Update.class})
    private String parkName;

    @NotBlank(groups = {ParkingLotDTO.Create.class,ParkingLotDTO.Update.class})
    @Length(max = 11, groups = {ParkingLotDTO.Create.class,ParkingLotDTO.Update.class})
    private String parkPlace;

    @NotNull(groups = {ParkingLotDTO.Create.class,ParkingLotDTO.Update.class})
    private Long parkPrice;

    private String parkStatus;

    public interface Create{}

    public interface Update{}
}
