package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "Bird")
public class Bird {
    @Id
    private String id;
    private String name;
    private String color;
    private String weight;
    private String height;

    public Person(@JsonProperty("id") String id,
                  @JsonProperty("name") String name,
                  @JsonProperty("color") String color,
                  @JsonProperty("weight") String weight,
                  @JsonProperty("height") String height) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.weight = weight;
        this.height = height;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    
    public String getColor() {
        return color;
    }
    
    public String getWeight() {
        return weight;
    }
    public String getHeight() {
        return height;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public void setHeight(String height) {
        this.height = height;
    }

}
