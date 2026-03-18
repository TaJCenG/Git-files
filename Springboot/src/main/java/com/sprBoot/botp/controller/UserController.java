package com.sprBoot.botp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprBoot.botp.exc.ResourceNotFoundException;
import com.sprBoot.botp.model.DeleteUser;
import com.sprBoot.botp.model.User;
import com.sprBoot.botp.model.UserResponse;
import com.sprBoot.botp.repo.UserRepository;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> getAllUsers() {
        List<User> use = userRepository.findAll();
        return use;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User  not found with id " + id));
        System.out.println("Hi bro");
        return ResponseEntity.ok(user);
    }

    @PostMapping("/post")
    public UserResponse saveUser (@RequestBody User user) {
        User savedUser  = userRepository.save(user);
        return new UserResponse("User  added successfully", savedUser ); // Return message and saved user
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser (@PathVariable Long id, @RequestBody User userDetails) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User  not found with id " + id));
        User updatedUser  = userRepository.save(user);
        return ResponseEntity.ok(updatedUser );
    }
    
    @DeleteMapping("/{id}")
    public DeleteUser deleteUser (@PathVariable Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User  not found with id to delete" + id));

        userRepository.delete(user);
        return new DeleteUser("User  deleted successfully", user); // Return message and user
    }
}