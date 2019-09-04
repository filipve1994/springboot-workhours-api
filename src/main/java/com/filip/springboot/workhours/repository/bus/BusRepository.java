package com.filip.springboot.workhours.repository.bus;

import com.filip.springboot.workhours.model.bus.Agency;
import com.filip.springboot.workhours.model.bus.Bus;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Arpit Khandelwal.
 */
public interface BusRepository extends MongoRepository<Bus, String> {
    Bus findByCode(String busCode);

    Bus findByCodeAndAgency(String busCode, Agency agency);
}
