package com.example.demo.dao;

import com.example.demo.model.Bird;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Optional;

@Component
public class BirdDao {

    private final BirdRepository birdRepository;

    public BirdDao(BirdRepository birdRepository) {
        this.birdRepository = birdRepository;
    }

    public Bird insertBirdData(Bird bird) {
        return birdRepository.insert(bird);
    }

    public Collection<Bird> getAllBirdInformation() {
        return birdRepository.findAll();
    }

    public Collection<Bird> getAllBirdInformationByColor(String color) {
        return birdRepository.findByColor(color);
    }

    public Optional<Bird> getAllBirdInformationByName(String name) {
        return birdRepository.findByName(name);
    }

    public Collection<Bird> getAllBirdInformationByNameAndColor(String name, String color) {
        return birdRepository.findByNameAndColor(name, color);
    }
    
    public Bird updateBirdUsingName(String name, Bird bird) {
        Optional<Bird> findBirdQuery = birdRepository.findByName(name);
        Bird birdValues = findBirdQuery.get();
        birdValues.setName(bird.getName());
        birdValues.setColor(bird.getColor());
        birdValues.setWeight(bird.getWeight());
        birdValues.setHeight(bird.getHeight());
        return birdRepository.save(birdValues);
    }

    public void deleteBirdUsingName(String name) {
        try {
            birdRepository.deleteByName(name);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }
    
}
