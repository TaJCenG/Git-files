package com.sprBoot.botp.repo;

import com.sprBoot.botp.model.UserEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserEntity, ObjectId> {
    UserEntity findByUserName(String username);

    void deleteByUserName(String username);
}
