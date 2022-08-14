package com.example.carparkproject.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ticket")
public class Ticket {

    @Id
    @Column(name = "ticket_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ticketId;

    @Column(name = "booking_time")
    private String bookingTime;

    @Column(name = "customer_name",nullable = false)
    private String customerName;

    @Column(name = "license_plate",nullable = false)
    private String licensePlate;

    @Column(name = "trip_id")
    private Long tripId;


}
