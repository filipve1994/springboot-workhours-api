package com.filip.springboot.workhours.repository.workhours;

import com.filip.springboot.workhours.model.workhours.WorkWeek;
import com.filip.springboot.workhours.model.workhours.Workday;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkWeekRepository extends MongoRepository<WorkWeek, String> {

    @Query(value = "{'id' : ?0}")
    WorkWeek findByIdQuery(String id);


}
