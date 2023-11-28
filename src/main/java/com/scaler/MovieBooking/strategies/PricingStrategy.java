package com.scaler.MovieBooking.strategies;

import com.scaler.MovieBooking.models.Booking;
import com.scaler.MovieBooking.models.ShowSeat;
import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface PricingStrategy {
    Double calculatePrice(Booking booking, List<ShowSeat> showSeats);
}
