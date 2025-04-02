package com.example.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.User;
import com.example.repos.UserRepository;
import com.example.services.UserService;
import com.example.services.dto.UserDTO;
import com.example.utils.ValidationUtil;

//import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolation;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    //@Transactional
    public void addUser(UserDTO userDTO) {
        if (!this.validationUtil.isValid(userDTO)) {

            this.validationUtil
                    .violations(userDTO)
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);

            return;
        }

        User user = this.modelMapper.map(userDTO, User.class);

        this.userRepository.saveAndFlush(user);
    }

    @Override
    public User findByUsername(String username) {
        return this.userRepository.findByUsername(username);
    }
    
}
