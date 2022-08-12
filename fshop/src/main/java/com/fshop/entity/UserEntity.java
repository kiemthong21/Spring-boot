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
@Table(name = "users")

public class UserEntity extends BaseEntity {
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private String fullname;
    @Column
    private Integer status;
    @Column
    private String address;
    @Column
    private String phone;
    @ManyToOne
    @JoinColumn(name = "role_id")

    private SettingEntity role;
}
