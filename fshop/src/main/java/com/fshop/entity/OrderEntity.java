package com.fshop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "orders")
@Data
@EqualsAndHashCode(callSuper = true)
public class OrderEntity extends BaseEntity {
    @Column(name = "receivername")
    private String receiverName;
    @Column(name = "receiverphone")
    private String receiverPhone;
    @Column(name = "receiveraddress")
    private String receiverAddress;
    @Column(name = "receivermail")
    private String receiverMail;
}
