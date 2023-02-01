package com.example.demo.dao;

import com.example.demo.model.Sighting;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Optional;

@Component
public class SightingDao {

    private final SightingRepository sightingRepository;

    public SightingDao(SightingRepository sightingRepository) {
        this.sightingRepository = sightingRepository;
    }

    public Sighting insertSightingData(Sighting sighting) {
        return sightingRepository.insert(sighting);
    }

    public Collection<Sighting> getAllSightingInformation() {
        return sightingRepository.findAll();
    }

    public Optional<Sighting> getSightingInformationById(String id) {
        return sightingRepository.findById(id);
    }

    public Collection<Sighting> getSightingInformationByBirdName(String birdName) {
        return sightingRepository.findByBirdName(birdName);
    }

    public Collection<Sighting> getSightingInformationByLocation(String location) {
        return sightingRepository.findByLocation(location);
    }

    public Collection<Sighting> getSightingInformationByBirdNameAndLocation(String birdName, String location) {
        return sightingRepository.findByBirdNameAndLocation(birdName, location);
    }

    public Sighting updateSightingUsingId(String id, Sighting sighting) {
        Optional<Sighting> findSightingQuery = sightingRepository.findById(id);
        Sighting sightingValues = findSightingQuery.get();
        sightingValues.setBirdName(sighting.getBirdName());
        sightingValues.setLocation(sighting.getLocation());
        sightingValues.setDatetime(sighting.getDatetime());
        return sightingRepository.save(sightingValues);
    }

    public void deleteSightingUsingId(String id) {
        try {
            sightingRepository.deleteById(id);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }

}
