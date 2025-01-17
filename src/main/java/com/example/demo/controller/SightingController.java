package com.example.demo.controller;

import com.example.demo.model.Sighting;
import com.example.demo.service.SightingService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("sightings")
public class SightingController {

    private final SightingService sightingService;
    public SightingController(SightingService sightingService) {
        this.sightingService = sightingService;
    }

    @PostMapping
    public Sighting create(@RequestBody Sighting sighting) {
        return sightingService.insertSightingData(sighting);
    }

    @GetMapping
    public Collection<Sighting> read() {
        return sightingService.getAllSightingInformation();
    }

    @GetMapping(path = "/bird/{birdName}")
    public Collection<Sighting> readQueryUsingBirdName(@PathVariable("birdName") String birdName) {
        return sightingService.getAllSightingInformationUsingBirdName(birdName);
    }

    @GetMapping(path = "/location/{location}")
    public Collection<Sighting> readQueryUsingLocation(@PathVariable("location") String location) {
        return sightingService.getAllSightingInformationUsingLocation(location);
    }
    
    @GetMapping(path = "/bird/{birdName}/location/{location}")
    public Collection<Sighting> readQueryUsingBirdNameAndLocation(@PathVariable("birdName") String birdName,@PathVariable("location") String location) {
        return sightingService.getAllSightingInformationUsingBirdNameAndLocation(birdName, location);
    }

    @PutMapping(path = "/update/{id}")
    public void update(@PathVariable String id, @RequestBody Sighting sighting ) {
        sightingService.updateSightingUsingId(id, sighting);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable("id") String id){
        sightingService.deleteSightingUsingId(id);
    }
}
