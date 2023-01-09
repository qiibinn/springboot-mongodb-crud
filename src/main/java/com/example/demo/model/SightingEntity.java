package com.example.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;

import static java.lang.String.format;

@Document(collection = "sightings")
@CompoundIndex(
    name = "bird-sighting-id",
    unique = true,
    def = "{'birdId': 1, 'sightingId' : 1}")
@Data
@NoArgsConstructor
public class SightingEntity {

  @Id private String id;

  @Version private Integer version;

  private int birdId;
  private int sightingId;
  private String location;
  private String datetimeStr;

  public SightingEntity(
      int birdId, int sightingId, String location, String datetimeStr) {
    this.birdId = birdId;
    this.sightingId = sightingId;
    this.location = location;
    this.datetimeStr = datetimeStr;
  }
}
