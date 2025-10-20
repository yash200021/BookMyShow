package com.example.bookmyshow.models;

import com.example.bookmyshow.models.enums.Feature;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@Entity
public class Show extends BaseModel{
    private Movie movie;
    private LocalTime startTime;
    private LocalTime endTime;
    private Screen screen;
    private List<Feature> feature;

}
