package com.example.demo.controller;

import com.example.demo.model.Sighting;
import com.example.demo.service.SightingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("sighting")
public class SightingController {

    private final SightingService sightingService;
    public SightingController(SightingService sightingService) {
        this.sightingService = sightingService;
    }

    @PostMapping
    public Bird create(@RequestBody Sighting sighting) {
        return sightingService.insertSightingData(sighting);
    }

    @GetMapping
    public Collection<Sighting> read() {
        return sightingService.getAllSightingInformation();
    }

    @GetMapping(path = "{id}")
    public Optional<Sighting> readQueryUsingId(@PathVariable("id") String id) {
        return sightingService.getSightingInformationUsingId(id);
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
