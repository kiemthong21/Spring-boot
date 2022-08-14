package com.example.carparkproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarDTO {

    @NotBlank(groups = {CarDTO.Create.class,CarDTO.Update.class})
    @Length(max = 50, groups = {CarDTO.Create.class,CarDTO.Update.class})
    private String licensePlate;

    @NotBlank(groups = {CarDTO.Create.class,CarDTO.Update.class})
    @Length(max = 11, groups = {CarDTO.Create.class,CarDTO.Update.class})
    private String color;

    @Length(max = 50, groups = {CarDTO.Create.class,CarDTO.Update.class})
    private String carType;

    @Length(max = 50, groups = {CarDTO.Create.class,CarDTO.Update.class})
    private String company;

    private Long parkId;

    private String parkName;

    public CarDTO(String licensePlate, String color, String carType, String company, String parkName) {
        this.licensePlate = licensePlate;
        this.color = color;
        this.carType = carType;
        this.company = company;
        this.parkName = parkName;
    }

    public interface Create{}

    public interface Update{}
}
