package com.example.bookmyshow.services;

import com.example.bookmyshow.models.ShowSeat;
import com.example.bookmyshow.models.ShowSeatType;
import com.example.bookmyshow.repositories.ShowSeatTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceCalculatorService {
    private final ShowSeatTypeRepository showSeatTypeRepository;

    public PriceCalculatorService(ShowSeatTypeRepository showSeatTypeRepository) {
        this.showSeatTypeRepository = showSeatTypeRepository;
    }

    public double calculateTotalPrice(List<ShowSeat> showSeats) {
        double finalPrice = 0;

        List<ShowSeatType> showSeatTypes = showSeatTypeRepository.findAllByShow(showSeats.get(0).getShow());
        for (ShowSeat showSeat : showSeats) {
            for (ShowSeatType showSeatType : showSeatTypes) {
                if (showSeat.getSeat().getSeatType().equals(showSeatType.getSeatType())) {
                    finalPrice += showSeatType.getPrice();
                    break;
                }
            }
        }
        return finalPrice;
    }
}
