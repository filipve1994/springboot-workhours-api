package com.filip.springboot.workhours.repository.bus;

import com.filip.springboot.workhours.model.bus.Trip;
import com.filip.springboot.workhours.model.bus.TripSchedule;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Arpit Khandelwal.
 */
public interface TripScheduleRepository extends MongoRepository<TripSchedule, String> {
    TripSchedule findByTripDetailAndTripDate(Trip tripDetail, String tripDate);
}