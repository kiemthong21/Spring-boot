package com.spring.springthymeleaf.service.impl;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.spring.springthymeleaf.converter.NewConverter;
import com.spring.springthymeleaf.dto.NewDTO;
import com.spring.springthymeleaf.entity.CategoryEntity;
import com.spring.springthymeleaf.entity.NewEntity;
import com.spring.springthymeleaf.repository.CategoryRepository;
import com.spring.springthymeleaf.repository.NewRepository;
import com.spring.springthymeleaf.service.INewService;

@Service
public class NewService implements INewService {

    @Override
    public List<NewDTO> findAll() {
        List<NewDTO> result = new ArrayList<>();
        List<NewEntity> entities = newRepository.findAll();
        for(NewEntity item: entities){
            NewDTO newDTO = newConverter.toDTO(item);
            result.add(newDTO);
        }
        return result;
    }

    @Autowired
    private NewRepository newRepository;

    @Override
    public List<NewDTO> findAll(Pageable pageable) {
        List<NewDTO> result = new ArrayList<>();
        List<NewEntity> entities = newRepository.findAll(pageable).getContent();
        for(NewEntity item: entities){
            NewDTO newDTO = newConverter.toDTO(item);
            result.add(newDTO);
        }
        return result;
    }

    @Override
    public int totalItem() {
        return (int) newRepository.count();
    }

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private NewConverter newConverter;

    @Override
    public NewDTO save(NewDTO newDTO) {
        NewEntity newEntity = new NewEntity();
        if (newDTO.getId() != null) {
            NewEntity oldNewEntity = newRepository.getOne(newDTO.getId());
            newEntity = newConverter.toEntity(newDTO, oldNewEntity);
        } else {
            newEntity = newConverter.toEntity(newDTO);
        }
        CategoryEntity categoryEntity = categoryRepository.findOneByCode(newDTO.getCategoryCode());
        newEntity.setCategory(categoryEntity);
        newEntity = newRepository.save(newEntity);
        return newConverter.toDTO(newEntity);
    }

    @Override
    public void delete(long[] ids) {
        for (long item : ids) {
            newRepository.deleteById(item);
        }

    }

}
