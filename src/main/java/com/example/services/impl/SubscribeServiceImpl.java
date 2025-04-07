package com.example.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.models.Subscribe;
import com.example.repos.base.BaseSubscribeRepository;
import com.example.services.dto.SubscribeDTO;
import com.example.utils.ValidationUtil;
import com.example.views.SubscribeRowViewModel;

import jakarta.validation.ConstraintViolation;

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

    public Page<SubscribeRowViewModel> getSubs(String username,Pageable pageable){
        return subscribeRepository.findBySubscribedUserUsername(username,pageable)
            .map(source -> modelMapper.map(source, SubscribeRowViewModel.class));
    }

    public void deleteById(int id){
        subscribeRepository.deleteById(id);
    }

    public boolean isUsersSub(int id,String subscribedUser){
        return subscribeRepository.existsByIdAndSubscribedUserUsername(id, subscribedUser);
    }

    public boolean isSubExist(String authorUsername,String subUsername){
        return subscribeRepository.existsByUserUsernameAndSubscribedUserUsername(authorUsername, subUsername);
    }

    public void create(SubscribeDTO subDTO){
         if (!this.validationUtil.isValid(subDTO)) {
            this.validationUtil
                    .violations(subDTO)
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);
            return;
        }
        Subscribe sub = this.modelMapper.map(subDTO, Subscribe.class);
        subscribeRepository.saveAndFlush(sub);
    }
}
