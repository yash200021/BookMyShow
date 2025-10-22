package com.example.bookmyshow.dtos.response;

import com.example.bookmyshow.models.Booking;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateBookingResponseDto {
    private Booking booking;
    private ResponseStatus status;
}
