package com.example.bookmyshow.models;

import com.example.bookmyshow.models.enums.BookingStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity(name = "bookings")
public class Booking extends BaseModel {
    @ManyToOne
    private User user;
    @Enumerated(EnumType.ORDINAL)
    private BookingStatus bookingStatus;
    @OneToMany
    private List<ShowSeat> showSeats;
    private double amount;
    @OneToMany
    private List<Payment> payments;
    private Date bookingDate;
}


/*

1            1
Booking --> User    --> m : 1
m            1

1           m
Booking --> ShowSeat --> 1 : m
1           1

1           m
Booking  -- > Payment  --> 1 : m
1           1
 */