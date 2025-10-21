package com.example.bookmyshow.models;

import com.example.bookmyshow.models.enums.Feature;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@Entity(name = "shows")
public class Show extends BaseModel{
    @ManyToOne
    private Movie movie;
    private LocalTime startTime;
    private LocalTime endTime;
    @ManyToOne
    private Screen screen;
    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Feature> feature;

}
/*
1          1
Show  --> Movie   --> m:1
m           1

1          1
Show  --> Screen  --> m:1
m           1
 */