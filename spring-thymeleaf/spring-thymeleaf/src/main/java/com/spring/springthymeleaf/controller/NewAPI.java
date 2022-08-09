package com.spring.springthymeleaf.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.spring.springthymeleaf.model.NewDTO;

@RestController
public class NewAPI {

    @PostMapping("/new")
    public NewDTO createNew(@RequestBody NewDTO model) {
        return model;
    }

    @PutMapping("/new")
    public NewDTO updateNew(@RequestBody NewDTO model) {
        return model;
    }

    @DeleteMapping("/new")
    public void deleteNew(@RequestBody long[] ids) {

    }
}
