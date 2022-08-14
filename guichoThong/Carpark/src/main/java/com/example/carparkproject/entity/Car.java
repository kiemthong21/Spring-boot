package com.example.carparkproject.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "car")
public class Car {

    @Id
    @Column(name = "license_plate")
    private String licensePlate;

    @Column(name = "color",nullable = false)
    private String color;

    @Column(name = "car_type")
    private String carType;

    @Column(name = "company")
    private String company;

    @Column(name = "park_id")
    private Long parkId;

}
