package com.example.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Seat extends BaseModel {
    private String seatNumber;
    private int rowNumber;
    private int columnNumber;
    @ManyToOne
    private SeatType seatType;
}

/*
1             1
Seat   --->  SeatType  --> m:1
m             1
 */
