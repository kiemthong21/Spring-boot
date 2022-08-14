package com.example.carparkproject.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "trip")
public class Trip {

    @Id
    @Column(name = "trip_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tripId;

    @Column(name = "booking_ticket_number")
    private Integer bookingTicketNumber;

    @Column(name = "car_type",nullable = false)
    private String carType;

    @Column(name = "departure_date",nullable = false)
    private Date departureDate;

    @Column(name = "departure_time",nullable = false)
    private String departureTime;

    @Column(name = "destination",nullable = false)
    private String destination;

    @Column(name = "driver",nullable = false)
    private String driver;

    @Column(name = "maximum_online_ticket_number",nullable = false)
    private Integer maximumOnlineTicketNumber;

    @Column(name = "maximum_online_ticket_number",insertable = false, updatable = false)
    private String maximumOnlineTicketNumberTemp;

}
