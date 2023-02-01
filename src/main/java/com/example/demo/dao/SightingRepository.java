package com.example.demo.dao;

import com.example.demo.model.Sighting;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SightingRepository extends MongoRepository<Sighting, String> {

    List<Sighting> findByBirdName(String birdName);
    List<Sighting> findByLocation(String location);
    List<Sighting> findByBirdNameAndLocation(String birdName, String location);

}
