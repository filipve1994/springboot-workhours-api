package com.filip.springboot.workhours.repository.workhours;

import com.filip.springboot.workhours.model.workhours.WorkMonth;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkMonthRepository extends MongoRepository<WorkMonth, String> {

    @Query(value = "{'id' : ?0}")
    WorkMonth findByIdQuery(String id);


}
