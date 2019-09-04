package com.filip.springboot.workhours.repository.bus;

import com.filip.springboot.workhours.model.bus.Agency;
import com.filip.springboot.workhours.model.user.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Arpit Khandelwal.
 */
public interface AgencyRepository extends MongoRepository<Agency, String> {
    Agency findByCode(String agencyCode);

    Agency findByOwner(User owner);

    Agency findByName(String name);
}
