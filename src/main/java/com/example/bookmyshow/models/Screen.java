package com.example.bookmyshow.models;

import com.example.bookmyshow.models.enums.Feature;
import com.example.bookmyshow.models.enums.ScreenStatus;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Screen extends BaseModel {
    private String name;
    private List<Seat> seats;
    private List<Feature> features;
    private ScreenStatus screenStatus;
}
