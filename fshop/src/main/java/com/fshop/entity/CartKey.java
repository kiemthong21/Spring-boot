package com.fshop.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class CartKey implements Serializable{
    @Column(name = "user_id")
    private Long userID;

    @Column(name = "product_id")
    private Long productId;


}
