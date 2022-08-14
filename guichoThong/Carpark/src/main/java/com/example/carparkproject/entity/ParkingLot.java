package com.example.carparkproject.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "parking_lot")
public class ParkingLot {

    @Id
    @Column(name = "park_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long parkId;

    @Column(name = "park_area", nullable = false)
    private Long parkArea;

    @Column(name = "park_name", nullable = false)
    private String parkName;

    @Column(name = "park_place", nullable = false)
    private String parkPlace;

    @Column(name = "park_price", nullable = false)
    private Long parkPrice;

    @Column(name = "park_status")
    private String parkStatus;

    @Column(name = "park_area", insertable = false, updatable = false)
    private String parkAreaTemp;

    @Column(name = "park_price", insertable = false, updatable = false)
    private String parkPriceTemp;

}
