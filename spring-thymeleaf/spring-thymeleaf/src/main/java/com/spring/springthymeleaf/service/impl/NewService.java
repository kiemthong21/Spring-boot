package com.spring.springthymeleaf.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.springthymeleaf.repository.NewRepository;
import com.spring.springthymeleaf.service.INewService;

public class NewService implements INewService {

    @Autowired
    private NewRepository newRepository;

}
