package com.example.carparkproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @Column(name = "employee_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    @Column(name = "account",unique = true,nullable = false)
    private String account;

    @Column(name = "department",nullable = false)
    private String department;

    @Column(name = "employee_address")
    private String employeeAddress;

    @Column(name = "employee_birthdate")
    private String employeeBirthdate;

    @Column(name = "employee_email")
    private String employeeEmail;

    @Column(name = "employee_name",nullable = false)
    private String employeeName;

    @Column(name = "employee_phone",nullable = false)
    private String employeePhone;

    @Column(name = "password",nullable = false)
    private String password;

    @Column(name = "sex",nullable = false)
    private String sex;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "employee_role_map",
            joinColumns = { @JoinColumn(name = "employee_id", referencedColumnName = "employee_id") },
            inverseJoinColumns = { @JoinColumn(name = "role_id", referencedColumnName = "role_id") }
    )
    private Set<Role> roles = new HashSet<>();

}
