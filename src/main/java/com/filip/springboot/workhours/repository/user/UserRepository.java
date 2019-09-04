package com.filip.springboot.workhours.repository.user;

import com.filip.springboot.workhours.model.user.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Arpit Khandelwal.
 */
public interface UserRepository extends MongoRepository<User, String> {

    User findByEmail(String email);

}
