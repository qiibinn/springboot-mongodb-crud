package com.example.demo.dao;

import com.example.demo.model.Bird;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BirdRepository extends MongoRepository<Bird, String> {
    List<Bird> findByColor(String color);
    Optional<Bird> findByName(String name);
    List<Bird> findByNameAndColor(String name, String color);
}
