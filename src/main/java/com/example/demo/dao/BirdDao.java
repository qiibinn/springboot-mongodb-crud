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

    public Optional<Bird> getBirdInformationById(String id) {
        return birdRepository.findById(id);
    }

    public Collection<Bird> getAllBirdInformationByColor(String color) {
        Bird bird = new Bird();
        bird.setColor(color);
        return birdRepository.findAll(bird);
    }

    public Collection<Bird> getAllBirdInformationByName(String name) {
        Bird bird = new Bird();
        bird.setName(name);
        return birdRepository.findAll(bird);
    }

    public Collection<Bird> getAllBirdInformationByNameAndColor(String name, String color) {
        Bird bird = new Bird();
        bird.setName(name);
        bird.setColor(color);
        return birdRepository.findAll(bird);
    }
    
    public Bird updateBirdUsingId(String id, Bird bird) {
        Optional<Bird> findBirdQuery = birdRepository.findById(id);
        Bird birdValues = findBirdQuery.get();
//         birdValues.setId(bird.getId());
        birdValues.setName(bird.getName());
        birdValues.setColor(bird.getColor());
        birdValues.setWeight(bird.getWeight());
        birdValues.setHeight(bird.getHeight());
        return birdRepository.save(birdValues);
    }

    public Collection<Bird> updateBirdUsingName(String name, Bird bird) {
        Collection<Bird> findBirdQuery = getAllBirdINformationByName(name);
        while (findBirdQuery.hasNext()) {
            Bird birdValues = findBirdQuery.next();
//         birdValues.setId(bird.getId());
            birdValues.setName(bird.getName());
            birdValues.setColor(bird.getColor());
            birdValues.setWeight(bird.getWeight());
            birdValues.setHeight(bird.getHeight());
            birdRepository.save(birdValues);
        }
        return getAllBirdINformationByName(name);
    }
    
    public void deleteBirdUsingId(String id) {
        try {
            birdRepository.deleteById(id);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }
    
    public void deleteBirdUsingName(String name) {
        try {
            Collection<Bird> findBirdQuery = getAllBirdINformationByName(name);
            while (findBirdQuery.hasNext()) {
                Bird birdValues = findBirdQuery.next();
                birdRepository.deleteById(birdValues.getId());
            }
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }

}
