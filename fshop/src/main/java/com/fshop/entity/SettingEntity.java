package com.fshop.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "settings")
public class SettingEntity extends BaseEntity{
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private String thumbnail;
    @Column
    private int ordinal;

    @OneToMany(mappedBy = "role")
    private List<UserEntity> users = new ArrayList<>();

    @OneToMany(mappedBy = "category")
    private List<ProductEntity> cates = new ArrayList<>();
}
