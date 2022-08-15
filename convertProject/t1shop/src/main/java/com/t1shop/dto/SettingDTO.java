package com.t1shop.dto;

import java.util.List;

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
public class SettingDTO {
    private Long settingid;
    private String settingName;
    private Integer ordinal;
    private Boolean statuss;
    private SettingGroupDTO group;
    private List<UserDTO> user;
    private List<ProductDTO> product; 
}
