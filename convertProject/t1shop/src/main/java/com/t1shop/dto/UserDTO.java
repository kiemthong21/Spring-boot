package com.t1shop.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDTO {
    private Long userid;
    private String phone;
    private String name;
    private Boolean gender;
    private String password;
    private String email;
    private String address;
    private String avatar;
    private Date dob;
    private SettingDTO roles;
}
