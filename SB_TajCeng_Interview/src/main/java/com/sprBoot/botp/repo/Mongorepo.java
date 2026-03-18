package com.sprBoot.botp.repo;

import com.sprBoot.botp.model.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface Mongorepo extends MongoRepository<User, ObjectId> {
    List<User> getUsersByName(String name);
}
