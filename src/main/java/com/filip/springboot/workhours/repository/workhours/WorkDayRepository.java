package com.filip.springboot.workhours.repository.workhours;

import com.filip.springboot.workhours.model.workhours.Workday;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkDayRepository extends MongoRepository<Workday, String> {

    @Query(value = "{'id' : ?0}")
    Workday findByIdQuery(String id);


}
