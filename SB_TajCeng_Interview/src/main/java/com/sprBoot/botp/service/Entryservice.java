package com.sprBoot.botp.service;

import com.sprBoot.botp.model.User;
import com.sprBoot.botp.model.UserEntity;
import com.sprBoot.botp.repo.Mongorepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Entryservice {

    @Autowired
    private Mongorepo repository;

    @Autowired
    private UserService userservice;

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public Optional<User> findById(ObjectId id) {
        return repository.findById(id);

    }

    public void saveUser (User user, String userName){
        UserEntity userEntity = userservice.findByUserName(userName);
        User saved = repository.save(user);
        userEntity.getUserEntries().add(saved);
        userservice.saveUser(userEntity);
    }

    public void deleteUser (ObjectId id){
        repository.deleteById(id);
    }
}
