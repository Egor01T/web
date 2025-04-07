package com.example.runner;

import java.time.ZonedDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.services.dto.UserDTO;
import com.example.services.impl.UserServiceImpl;
import com.github.javafaker.Faker;

@Component
public class Clr implements CommandLineRunner{

    private Faker faker = new Faker();
    private final UserServiceImpl userService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public Clr(UserServiceImpl userService,PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        
        System.out.println("Clr is running...");
        System.out.println("Adding random User");

        String pass = faker.number().digits(5);

        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(faker.name().username());
        userDTO.setEmail(faker.internet().emailAddress());
        userDTO.setPassHash(passwordEncoder.encode(pass));
        userDTO.setCreatedAt(ZonedDateTime.now());

        System.out.println("username: "+userDTO.getUsername()+"\n"+
            "email: "+userDTO.getEmail()+"\n"+
            "pass: "+pass+"\n"+
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
