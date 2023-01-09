package com.example.demo.service;

import com.example.demo.dao.PersonDao;
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

    public Optional<Bird> getBirdInformationUsingId(String id) {
        return birdDao.getBirdInformationById(id);
    }

    public void updateBirdUsingId(String id, Bird bird) {
         birdDao.updateBirdUsingId(id, bird);
    }

    public void deleteBirdUsingId(String id) {
        birdDao.deleteBirdUsingId(id);
    }

}
