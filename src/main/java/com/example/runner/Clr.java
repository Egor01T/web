package com.example.runner;

import java.time.ZonedDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.services.UserService;
import com.example.services.dto.UserDTO;
import com.github.javafaker.Faker;

@Component
public class Clr implements CommandLineRunner{

    private Faker faker = new Faker();
    private final UserService userService;

    @Autowired
    public Clr(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        
        System.out.println("Clr is running...");
        System.out.println("Adding random User");

        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(faker.name().username());
        userDTO.setEmail(faker.internet().emailAddress());
        userDTO.setPassHash(faker.crypto().sha256());
        userDTO.setCreatedAt(ZonedDateTime.now());

        System.out.println("username: "+userDTO.getUsername()+"\n"+
            "email: "+userDTO.getEmail()+"\n"+
            "pass hash: "+userDTO.getPassHash()+"\n"+
            "created at: "+userDTO.getCreatedAt()+"\n"
        );

        try {
            this.userService.addUser(userDTO);
            System.out.println("Random User added successfully!");
        } catch (Exception e){
            System.out.println("Some Error happend while adding User:\n" + e);
        }
    }
    
}
