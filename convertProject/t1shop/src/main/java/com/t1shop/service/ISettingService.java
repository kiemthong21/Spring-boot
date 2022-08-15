package com.t1shop.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.t1shop.dto.SettingDTO;
import com.t1shop.model.Setting;

public interface ISettingService {
    //get all setting by group
    ResponseEntity<List<SettingDTO>> getSettingByGroup(Long id);

    //convert Entity to DTO
    SettingDTO maptoDto(Setting setting);

    //convert DTO to Entity
    Setting maptoEntity(SettingDTO settingDTO);

    
}
