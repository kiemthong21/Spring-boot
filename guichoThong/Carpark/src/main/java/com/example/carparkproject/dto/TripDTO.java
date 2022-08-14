package com.example.carparkproject.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class TripDTO {

    private Long tripId;

    private Integer bookingTicketNumber;

    @NotBlank(groups = {TripDTO.Create.class, TripDTO.Update.class})
    @Length(max = 50, groups = {TripDTO.Create.class, TripDTO.Update.class})
    private String carType;

    @NotBlank(groups = {TripDTO.Create.class, TripDTO.Update.class})
    @Length(max = 50, groups = {TripDTO.Create.class, TripDTO.Update.class})
    private String departureDate;

    @NotBlank(groups = {TripDTO.Create.class, TripDTO.Update.class})
    @Length(max = 50, groups = {TripDTO.Create.class, TripDTO.Update.class})
    private String departureTime;

    @NotBlank(groups = {TripDTO.Create.class, TripDTO.Update.class})
    @Length(max = 50, groups = {TripDTO.Create.class, TripDTO.Update.class})
    private String destination;

    @NotBlank(groups = {TripDTO.Create.class, TripDTO.Update.class})
    @Length(max = 50, groups = {TripDTO.Create.class, TripDTO.Update.class})
    private String driver;

    @NotNull(groups = {TripDTO.Create.class, TripDTO.Update.class})
    @Length(max = 50, groups = {TripDTO.Create.class, TripDTO.Update.class})
    private Integer maximumOnlineTicketNumber;

    public interface Create {
    }

    public interface Update {
    }

}
