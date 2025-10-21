package com.example.bookmyshow.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity(name = "movies")
public class Movie extends BaseModel {
    private String name;
    private double rating;
}
