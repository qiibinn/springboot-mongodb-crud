package com.example.demo.dao;

import com.example.demo.model.Sighting;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SightingRepository extends MongoRepository<Sighting, String> {

}
