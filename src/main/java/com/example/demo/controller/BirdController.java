package com.example.demo.controller;

import com.example.demo.model.Bird;
import com.example.demo.service.BirdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("bird")
public class BirdController {

    private final BirdService birdService;
    public BirdController(BirdService birdService) {
        this.birdService = birdService;
    }

    @PostMapping
    public Bird create(@RequestBody Bird bird) {
        return birdService.insertBirdData(bird);
    }

    @GetMapping
    public Collection<Bird> read() {
        return birdService.getAllBirdInformation();
    }

    @GetMapping(path = "{id}")
    public Optional<Bird> readQueryUsingId(@PathVariable("id") String id) {
        return birdService.getBirdInformationUsingId(id);
    }

    @PutMapping(path = "/update/{id}")
    public void update(@PathVariable String id, @RequestBody Bird bird ) {
        birdService.updateBirdUsingId(id, bird);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable("id") String id){
        birdService.deleteBirdUsingId(id);
    }
}
