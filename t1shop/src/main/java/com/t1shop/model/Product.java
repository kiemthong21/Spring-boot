package com.t1shop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productid;
    @Column(name = "title", length = 50)
    private String title;
    @Column(name = "summary", length = 300)
    private String summary;
    @Column(name = "price")
    private Double price;
    @Column(name = "discount")
    private int discount;
    @Column(name = "quantity")
    private int quantity;
    @Column(name  = "thumbnail")
    private String thumbnail;
    @ManyToOne
    @JoinColumn(name = "category")
    private Setting productCategory;

}
