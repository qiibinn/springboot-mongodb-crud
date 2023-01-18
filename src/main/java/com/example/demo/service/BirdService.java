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

    public Collection<Bird> getAllBirdInformationUsingColor(String color) {
        return birdDao.getAllBirdInformationByColor(color);
    }

    public Collection<Bird> getAllBirdInformationUsingNameAndColor(String name, String color) {
        return birdDao.getAllBirdInformationByNameAndColor(name, color);
    }

    public Optional<Bird> getBirdInformationUsingName(String name) {
        return birdDao.getBirdInformationByName(name);
    }

    public void updateBirdUsingName(String name, Bird bird) {
         birdDao.updateBirdUsingName(name, bird);
    }

    public void deleteBirdUsingName(String name) {
        birdDao.deleteBirdUsingName(name);
    }

}
