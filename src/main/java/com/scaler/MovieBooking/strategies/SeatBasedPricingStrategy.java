package com.scaler.MovieBooking.strategies;

import com.scaler.MovieBooking.enums.SeatType;
import com.scaler.MovieBooking.models.Booking;
import com.scaler.MovieBooking.models.ShowSeat;
import org.springframework.stereotype.Component;

import java.util.List;
@Component("seatBasedStrategy")
public class SeatBasedPricingStrategy implements PricingStrategy{
    @Override
    public Double calculatePrice(Booking booking, List<ShowSeat> showSeats) {
        return showSeats.stream().mapToDouble(seat -> getPrice(seat.getSeat().getSeatType())).sum();
    }

    private static double getPrice(SeatType seatType) {
        switch (seatType){
            case VIP -> {
                return 2000.0;
            }
            case GOLD -> {
                return 500.0;
            }
            case SILVER -> {
                return 250.0;
            }
            case PLATINUM -> {
                return 1000.0;
            }
        }
        throw new IllegalArgumentException("Invalid Seat Type :" + seatType );

    }
}
