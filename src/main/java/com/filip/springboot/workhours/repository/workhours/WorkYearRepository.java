package com.filip.springboot.workhours.repository.workhours;

import com.filip.springboot.workhours.model.workhours.WorkYear;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkYearRepository extends MongoRepository<WorkYear, String> {

    @Query(value = "{'id' : ?0}")
    WorkYear findByIdQuery(String id);

    WorkYear findByYear(Integer year);


}
