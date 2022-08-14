package com.example.carparkproject.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "booking_office")
public class BookingOffice {

    @Id
    @Column(name = "office_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long officeId;

    @Column(name = "end_contract_deadline")
    private String endContractDeadline;

    @Column(name = "office_name",nullable = false)
    private String officeName;

    @Column(name = "office_phone",nullable = false)
    private String officePhone;

    @Column(name = "office_place",nullable = false)
    private String officePlace;

    @Column(name = "office_price",nullable = false)
    private Long officePrice;

    @Column(name = "start_contract_deadline")
    private String startContractDeadline;

    @Column(name = "trip_id")
    private Long tripId;
}
