package com.filip.springboot.workhours.repository.user;

import com.filip.springboot.workhours.model.user.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Arpit Khandelwal.
 */
public interface RoleRepository extends MongoRepository<Role, String> {

    Role findByRole(String role);

}
