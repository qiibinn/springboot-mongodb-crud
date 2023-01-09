package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "Sighting")
public class Sighting {
    @Id
    private String id;
    private String birdId;
    private String location;
    private String datetime;

    public Person(@JsonProperty("id") String id,
                  @JsonProperty("birdId") String birdId,
                  @JsonProperty("location") String location,
                  @JsonProperty("datetime") String datetime) {
        this.id = id;
        this.birdId = birdId;
        this.location = location;
        this.datetime = datetime;
    }

    public String getId() {
        return id;
    }

    public String getBirdId() {
        return birdId;
    }

    public String getLocation() {
        return location;
    }
  
    public String getDatetime() {
        return datetime;
    }
  
    public void setId(String id) {
        this.id = id;
    }

    public void setBirdId(String birdId) {
        this.birdId = birdId;
    }

    public void setLocation(String location) {
        this.location = location;
    }
  
    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }
}
