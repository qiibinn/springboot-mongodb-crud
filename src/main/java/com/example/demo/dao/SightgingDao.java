package com.example.demo.dao;

import com.example.demo.model.Sighting;
import org.springframework.beans.factory.annotation.Autowired;
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

    public Sighting updateSightingUsingId(String id, Sighting sighting) {
        Optional<Sighting> findSightingQuery = sightingRepository.findById(id);
        Sighting sightingValues = findSightingQuery.get();
        sightingValues.setId(sighting.getId());
        sightingValues.setBirdId(sighting.getBirdId());
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
