package com.fsoft.carpark.dto;

import lombok.Data;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

import com.fsoft.carpark.dto.CarDto;

@Data
public class TicketDto implements Serializable {
    private Long ticketId;
    private Time bookingTime;
    private String customerName;
    private String licensePlate;
    private Long tripId;
}
