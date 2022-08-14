package com.fsoft.carpark.dto;

import com.fsoft.carpark.dto.TicketDto;
import com.fsoft.carpark.model.BookingOffice;
import com.fsoft.carpark.model.Ticket;

import lombok.Data;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Data
public class TripDto implements Serializable {
    private Long tripId;
    private Integer bookedTicketNumber;
    private String carType;
    private Date departureDate;
    private Time departureTime;
    private String destination;
    private String driver;
    private Integer maximumOnlineTicketNumber;
    private List<BookingOfficeDto> bookingOffice;
    private List<TicketDto> ticket;
}
