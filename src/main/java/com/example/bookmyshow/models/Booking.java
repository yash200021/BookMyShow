package com.example.bookmyshow.models;

import com.example.bookmyshow.models.enums.BookingStatus;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Booking extends BaseModel {
    private User user;
    private BookingStatus bookingStatus;
    private List<ShowSeat> showSeats;
    private double amount;
    private List<Payment> payments;
    private Date bookingDate;
}
