package com.filip.springboot.workhours.repository;

import com.filip.springboot.workhours.model.Products;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Products, String> {

    @Override
    void delete(Products deleted);
}
