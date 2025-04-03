package com.example.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.repos.base.BaseSubscribeRepository;
import com.example.utils.ValidationUtil;

@Service
public class SubscribeServiceImpl {
    private final BaseSubscribeRepository subscribeRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    @Autowired
    public SubscribeServiceImpl(BaseSubscribeRepository subscribeRepository, ModelMapper modelMapper,ValidationUtil validationUtil) {
        this.subscribeRepository = subscribeRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    
}
