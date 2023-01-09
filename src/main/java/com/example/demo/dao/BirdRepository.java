package com.example.demo.dao;

import com.example.demo.model.Bird;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BirdRepository extends MongoRepository<Bird, String> {

}
