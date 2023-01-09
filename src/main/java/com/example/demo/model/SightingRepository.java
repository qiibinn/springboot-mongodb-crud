package com.example.demo.model;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

//FIXME to be documented and to be pageable

@Repository
public interface SightingRepository
    extends ReactiveCrudRepository<SightingEntity, String> {

  Flux<SightingEntity> findByBirdId(int birdId);
}
