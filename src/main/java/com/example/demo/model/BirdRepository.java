package com.example.demo.model;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface BirdRepository extends ReactiveCrudRepository<BirdEntity, String> {

  Mono<BirdEntity> findByBirdId(int birdId);
}
