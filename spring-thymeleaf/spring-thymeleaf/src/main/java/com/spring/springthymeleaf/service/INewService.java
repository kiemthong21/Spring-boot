package com.spring.springthymeleaf.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.spring.springthymeleaf.dto.NewDTO;

public interface INewService {
    NewDTO save(NewDTO newDTO);
    void delete(long[] ids);
    List<NewDTO> findAll(Pageable pageable);
    List<NewDTO> findAll();
    int totalItem();

    NewDTO findNewByTitle1(String title);

   
}
