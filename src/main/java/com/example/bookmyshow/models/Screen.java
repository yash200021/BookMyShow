package com.example.bookmyshow.models;

import com.example.bookmyshow.models.enums.Feature;
import com.example.bookmyshow.models.enums.ScreenStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "screens")
public class Screen extends BaseModel {
    private String name;
    @OneToMany
    private List<Seat> seats;
    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Feature> features;
    @Enumerated(EnumType.ORDINAL)
    private ScreenStatus screenStatus;
}

/*
1          m
Screen --> Seat   --> 1:m
1           1
 */
