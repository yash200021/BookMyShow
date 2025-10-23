package com.example.bookmyshow.controllers;

import com.example.bookmyshow.dtos.request.CreateBookingRequestDto;
import com.example.bookmyshow.dtos.response.CreateBookingResponseDto;
import com.example.bookmyshow.dtos.response.ResponseStatus;
import com.example.bookmyshow.exceptions.ShowSeatNotAvailableException;
import com.example.bookmyshow.exceptions.UserNotFoundException;
import com.example.bookmyshow.models.Booking;
import com.example.bookmyshow.services.BookingService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bookings")
public class BookingController {
    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public CreateBookingResponseDto createBooking(@RequestBody CreateBookingRequestDto createBookingRequestDto) throws UserNotFoundException, ShowSeatNotAvailableException {
        CreateBookingResponseDto responseDto = new CreateBookingResponseDto();
        Booking booking = bookingService.createBooking(
                createBookingRequestDto.getShowSeatIds(),
                createBookingRequestDto.getUserId()
        );
        responseDto.setBooking(booking);
        responseDto.setStatus(ResponseStatus.SUCCESS);

        if(booking == null) {
            responseDto.setStatus(ResponseStatus.FAILURE);
        }

        return responseDto;
    }


}

