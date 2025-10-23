package com.example.bookmyshow.services;

import com.example.bookmyshow.exceptions.ShowSeatNotAvailableException;
import com.example.bookmyshow.exceptions.UserNotFoundException;
import com.example.bookmyshow.models.Booking;
import com.example.bookmyshow.models.ShowSeat;
import com.example.bookmyshow.models.User;
import com.example.bookmyshow.models.enums.BookingStatus;
import com.example.bookmyshow.models.enums.ShowSeatStatus;
import com.example.bookmyshow.repositories.BookingRepository;
import com.example.bookmyshow.repositories.ShowSeatRepository;
import com.example.bookmyshow.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    private final UserRepository userRepository;
    private final ShowSeatRepository showSeatRepository;
    private final PriceCalculatorService priceCalculatorService;
    private final BookingRepository bookingRepository;

    public BookingService(UserRepository userRepository,
                          ShowSeatRepository showSeatRepository,
                          PriceCalculatorService priceCalculatorService,
                          BookingRepository bookingRepository) {
        this.userRepository = userRepository;
        this.showSeatRepository = showSeatRepository;
        this.priceCalculatorService = priceCalculatorService;
        this.bookingRepository = bookingRepository;
    }
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Booking createBooking(List<Long> showSeatIds, Long userId) throws UserNotFoundException, ShowSeatNotAvailableException {
        Optional<User> optionalUser = userRepository.findById(userId);
        if(optionalUser.isEmpty()) {
            throw new UserNotFoundException("User with id " + userId + " not found");
        }

        User user = optionalUser.get();
        List<ShowSeat> showSeats = showSeatRepository.findAllById(showSeatIds);
        for(ShowSeat showSeat : showSeats) {
            if(!showSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE)) {
                throw new ShowSeatNotAvailableException("ShowSeat with showId: " + showSeat.getShow().getId() +
                        "and seatId: " + showSeat.getSeat().getId() + " is not available");
            }
        }

        List<ShowSeat> savedShowSeat = new ArrayList<>();

        for (ShowSeat showSeat : showSeats) {
            showSeat.setShowSeatStatus(ShowSeatStatus.BLOCKED);
            savedShowSeat.add(showSeatRepository.save(showSeat));
        }

        //Create the Booking Object with Status as PENDING.
        Booking booking = new Booking();
        booking.setUser(user);
        booking.setShowSeats(savedShowSeat);
        booking.setBookingStatus(BookingStatus.PENDING);
        booking.setAmount(priceCalculatorService.calculateTotalPrice(savedShowSeat));

        return bookingRepository.save(booking);
    }
}
