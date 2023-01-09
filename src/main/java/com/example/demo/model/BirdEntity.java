package com.example.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "birds")
@Data
@NoArgsConstructor
public class BirdEntity {
  @Id private String id;

  @Version private Integer version;

  @Indexed(unique = true)
  private int birdId;

  private String name;
  private String color;
  private int weight;
  private int height;

  public BirdEntity(int birdId, String name, String color, int weight, int height) {
    this.birdId = birdId;
    this.name = name;
    this.color = color;
    this.weight = weight;
    this.height = height;
  }
}
