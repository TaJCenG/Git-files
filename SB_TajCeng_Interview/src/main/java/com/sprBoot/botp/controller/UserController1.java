package com.sprBoot.botp.controller;

import com.sprBoot.botp.model.User;
import com.sprBoot.botp.model.UserEntity;
import com.sprBoot.botp.service.Entryservice;
import com.sprBoot.botp.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController1 {
    @Autowired
    private Entryservice entryservice;

    @Autowired
    private UserService userservice;


    @GetMapping
    public ResponseEntity<?> getAllUsersOfUser(@PathVariable String username) {
        UserEntity user = userservice.findByUserName(username);
        List<User> all = user.getUserEntries();
        if (all != null && !all.isEmpty())  {
            return new ResponseEntity<>(all, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable ObjectId id) {

        Optional<User> get = entryservice.findById(id);
        if (get.isPresent()) {
            return new ResponseEntity<>(get.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(get.get(), HttpStatus.NOT_FOUND);
    }

    @PostMapping("/post")
    public ResponseEntity<User> createUser (@RequestBody User user, @PathVariable String userName){
        try{

            user.setDate(LocalDateTime.now());
            entryservice.saveUser(user,userName);
            return new ResponseEntity<>(user,HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(user,HttpStatus.BAD_REQUEST);
        }

      // Return message and saved user
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> updateUserById (@PathVariable ObjectId id, @RequestBody User newUser) {
      User old =  entryservice.findById(id).orElse(null);
      if (old != null) {
          old.setName(newUser.getName() != null && !newUser.getName().equals("") ? newUser.getName() : old.getName());
          old.setEmail(newUser.getEmail() !=null && !newUser.getEmail().equals("") ? newUser.getEmail() : old.getEmail());
          old.setAddress(newUser.getAddress() !=null && !newUser.getAddress().equals("") ? newUser.getAddress() : old.getAddress());
entryservice.saveUser(old, newUser.getName());
          return new ResponseEntity<>(old, HttpStatus.OK);
      }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);//
    }
    
    @DeleteMapping("/{id}")
    public boolean deleteUser (@PathVariable ObjectId id) {
entryservice.deleteUser(id);
        return true; // Return message and user
    }
}