package com.example.demo.controller;

import com.example.demo.model.Bird;
import com.example.demo.service.BirdService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("birds")
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

    @GetMapping(path = "/color/{color}")
    public Collection<Bird> readQueryUsingColor(@PathVariable("color") String color) {
        return birdService.getAllBirdInformationUsingColor(color);
    }
    
    @GetMapping(path = "/name/{name}")
    public Optional<Bird> readQueryUsingName(@PathVariable("name") String name) {
        return birdService.getBirdInformationUsingName(name);
    }
    
    @GetMapping(path = "/name/{name}/color/{color}")
    public Collection<Bird> readQueryUsingNameAndColor(@PathVariable("name") String name, @PathVariable("color") String color) {
        return birdService.getAllBirdInformationUsingNameAndColor(name, color);
    }

    @PutMapping(path = "/update/name/{name}")
    public void update(@PathVariable("name") String name, @RequestBody Bird bird ) {
        birdService.updateBirdUsingName(name, bird);
    }

    @DeleteMapping(path = "/delete/name/{name}")
    public void delete(@PathVariable("name") String name){
        birdService.deleteBirdUsingName(name);
    }
}
