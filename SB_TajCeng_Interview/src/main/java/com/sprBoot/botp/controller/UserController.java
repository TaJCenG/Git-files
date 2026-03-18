package com.sprBoot.botp.controller;

import com.sprBoot.botp.model.User;
import com.sprBoot.botp.model.UserEntity;
import com.sprBoot.botp.repo.UserRepository;
import com.sprBoot.botp.service.UserService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/user")
//@Tag(name = "User APIs", description = "Read, Update & Delete User")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private WeatherService weatherService;

    @PostMapping("/post")
    public ResponseEntity<UserEntity> saveUser (@RequestBody UserEntity user){
        try{
            userService.saveUser(user);
            return new ResponseEntity<>(user,HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(user,HttpStatus.BAD_REQUEST);
        }

        // Return message and saved user
    }

    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody UserEntity user) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String userName = authentication.getName();
//        UserEntity userInDb = userService.findByUserName(userName);
//        userInDb.setUserName(user.getUserName());
//        userInDb.setPassword(user.getPassword());
        userService.saveNewUser( user);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

//    @DeleteMapping
//    public ResponseEntity<?> deleteUserById() {
//        //Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        userRepository.deleteByUserName(UserEntity);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }

    @GetMapping
    public ResponseEntity<?> greeting() {
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        WeatherResponse weatherResponse = weatherService.getWeather("Mumbai");
//        String greeting = "";
//        if (weatherResponse != null) {
//            greeting = ", Weather feels like " + weatherResponse.getCurrent().getFeelslike();
//        }
//        return new ResponseEntity<>("Hi " + authentication.getName() + greeting, HttpStatus.OK);
//    }

}