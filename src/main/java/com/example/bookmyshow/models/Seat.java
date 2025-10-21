package com.example.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "seats")
public class Seat extends BaseModel {
    private String seatNumber;
    private int rowValue;
    private int columnValue;
    @ManyToOne
    private SeatType seatType;
}

/*
1             1
Seat   --->  SeatType  --> m:1
m             1
 */
