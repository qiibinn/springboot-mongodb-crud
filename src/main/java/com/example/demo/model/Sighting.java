package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Sighting")
public class Sighting {
    private String id;
    private String birdName;
    private String location;
    private String datetime;

    public Sighting() {
        this.id = null;
        this.birdName = null;
        this.location = null;
        this.datetime = null;
    }

    public Sighting(@JsonProperty("id") String id,
                    @JsonProperty("birdName") String birdName,
                    @JsonProperty("location") String location,
                    @JsonProperty("datetime") String datetime) {
        this.id = id;
        this.birdName = birdName;
        this.location = location;
        this.datetime = datetime;
    }

    public String getId() {
        return id;
    }

    public String getBirdName() {
        return birdName;
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
    
    public void setBirdName(String birdName) {
        this.birdName = birdName;
    }

    public void setLocation(String location) {
        this.location = location;
    }
  
    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }
}
