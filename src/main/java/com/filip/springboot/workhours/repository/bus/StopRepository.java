package com.filip.springboot.workhours.repository.bus;

import com.filip.springboot.workhours.model.bus.Stop;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Arpit Khandelwal.
 */
public interface StopRepository extends MongoRepository<Stop, String> {
    Stop findByCode(String code);
}
