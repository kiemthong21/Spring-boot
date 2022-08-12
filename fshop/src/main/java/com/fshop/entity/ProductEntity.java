package com.fshop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "product")
public class ProductEntity extends BaseEntity{
    @Column
    private String title;
    @Column
    private String desciption;
    @Column
    private Double price;
    @Column
    private Integer status;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private SettingEntity category;
}
