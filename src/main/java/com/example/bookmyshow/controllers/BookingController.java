package com.example.bookmyshow.controllers;

import com.example.bookmyshow.dtos.request.CreateBookingRequestDto;
import com.example.bookmyshow.models.Booking;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bookings")
public class BookingController {
    @PostMapping
    public CreateBookingRequestDto createBooking(@RequestBody CreateBookingRequestDto createBookingRequestDto){
        return null;
    }
}

