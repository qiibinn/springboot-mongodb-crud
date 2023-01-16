package com.example.demo.service;

import com.example.demo.dao.BirdDao;
import com.example.demo.model.Bird;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class BirdService {

    private final BirdDao birdDao;

    public BirdService(BirdDao birdDao) {
        this.birdDao = birdDao;
    }

    public Bird insertBirdData(Bird bird) {
        return birdDao.insertBirdData(bird);
    }

    public Collection<Bird> getAllBirdInformation() {
        return birdDao.getAllBirdInformation();
    }

    public Collection<Bird> getAllBirdInformationByColor(String color) {
        return birdDao.getAllBirdInformation(color);
    }

    public Collection<Bird> getAllBirdInformationByNameAndColor(String name, String color) {
        return birdDao.getAllBirdInformation(name, color);
    }

    public Optional<Bird> getBirdInformationUsingId(String id) {
        return birdDao.getBirdInformationById(id);
    }

    public void updateBirdUsingId(String id, Bird bird) {
         birdDao.updateBirdUsingId(id, bird);
    }

    public void updateBirdUsingName(String name, Bird bird) {
         birdDao.updateBirdUsingName(name, bird);
    }

    public void deleteBirdUsingId(String id) {
        birdDao.deleteBirdUsingId(id);
    }

    public void deleteBirdUsingName(String name) {
        birdDao.deleteBirdUsingName(name);
    }
}
