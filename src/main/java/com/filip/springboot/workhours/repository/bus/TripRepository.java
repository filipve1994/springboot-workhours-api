package com.filip.springboot.workhours.repository.bus;

import com.filip.springboot.workhours.model.bus.Agency;
import com.filip.springboot.workhours.model.bus.Bus;
import com.filip.springboot.workhours.model.bus.Stop;
import com.filip.springboot.workhours.model.bus.Trip;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by Arpit Khandelwal.
 */
public interface TripRepository extends MongoRepository<Trip, String> {
    Trip findBySourceStopAndDestStopAndBus(Stop source, Stop destination, Bus bus);

    List<Trip> findAllBySourceStopAndDestStop(Stop source, Stop destination);

    List<Trip> findByAgency(Agency agency);
}
