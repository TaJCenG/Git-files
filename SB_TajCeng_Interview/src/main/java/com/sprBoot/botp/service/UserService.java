package com.sprBoot.botp.service;

import com.sprBoot.botp.model.User;
import com.sprBoot.botp.model.UserEntity;
import com.sprBoot.botp.repo.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;

   // private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public boolean saveNewUser(UserEntity user) {
        try {
//            user.setPassword(passwordEncoder.encode(user.getPassword()));
//            user.setRoles(Arrays.asList("USER"));
            userRepository.save(user);
            return true;
        } catch (Exception e) {
            log.error("hahahhahhahahahah");
            log.warn("hahahhahhahahahah");
            log.info("hahahhahhahahahah");
            log.debug("hahahhahhahahahah");
            log.trace("hahahhahhahahahah");
            return false;
        }
    }

    public void saveAdmin(UserEntity user) {
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        user.setRoles(Arrays.asList("USER", "ADMIN"));
        userRepository.save(user);
    }


    public void saveUser(UserEntity user) {
        userRepository.save(user);
    }

    public List<UserEntity> getAll() {
        return userRepository.findAll();
    }

    public Optional<UserEntity> findById(ObjectId id) {
        return userRepository.findById(id);
    }

    public void deleteById(ObjectId id) {
        userRepository.deleteById(id);
    }

    public UserEntity findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }
}