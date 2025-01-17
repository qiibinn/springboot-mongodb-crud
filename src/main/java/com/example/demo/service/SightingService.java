package com.example.demo.service;

import com.example.demo.dao.SightingDao;
import com.example.demo.model.Sighting;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class SightingService {

    private final SightingDao sightingDao;

    public SightingService(SightingDao sightingDao) {
        this.sightingDao = sightingDao;
    }

    public Sighting insertSightingData(Sighting sighting) {
        return sightingDao.insertSightingData(sighting);
    }

    public Collection<Sighting> getAllSightingInformation() {
        return sightingDao.getAllSightingInformation();
    }

    public Optional<Sighting> getSightingInformationUsingId(String id) {
        return sightingDao.getSightingInformationById(id);
    }

    public Collection<Sighting> getAllSightingInformationUsingBirdName(String birdName) {
        return sightingDao.getSightingInformationByBirdName(birdName);
    }

    public Collection<Sighting> getAllSightingInformationUsingLocation(String location) {
        return sightingDao.getSightingInformationByLocation(location);
    }

    public Collection<Sighting> getAllSightingInformationUsingBirdNameAndLocation(String birdName, String location) {
        return sightingDao.getSightingInformationByBirdNameAndLocation(birdName, location);
    }

    public void updateSightingUsingId(String id, Sighting sighting) {
         sightingDao.updateSightingUsingId(id, sighting);
    }

    public void deleteSightingUsingId(String id) {
        sightingDao.deleteSightingUsingId(id);
    }

}
