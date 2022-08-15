package com.t1shop.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.t1shop.dto.SettingDTO;
import com.t1shop.model.Setting;
import com.t1shop.model.SettingGroup;
import com.t1shop.repository.SettingRepository;
import com.t1shop.service.ISettingService;

@Service
public class SettingService implements ISettingService {

    private SettingRepository settingRepository;
    private ModelMapper modelMapper;

    @Autowired
    public SettingService(SettingRepository settingRepository, ModelMapper modelMapper) {
        this.settingRepository = settingRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public SettingDTO maptoDto(Setting setting) {
        SettingDTO settingDTO = modelMapper.map(setting, SettingDTO.class);
        return settingDTO;
    }

    @Override
    public Setting maptoEntity(SettingDTO settingDTO) {
        Setting setting = modelMapper.map(settingDTO, Setting.class);
        return setting;
    }

    @Override
    public ResponseEntity<List<SettingDTO>> getSettingByGroup(Long id) {
        SettingGroup group = new SettingGroup();
        group.setGroupid(id);
        List<SettingDTO> setting = settingRepository.findByGroup(group).stream().map(this::maptoDto).collect(Collectors.toList());
        return ResponseEntity.ok(setting);
    }


}
