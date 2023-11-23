package com.scaler.MovieBooking.service;

import com.scaler.MovieBooking.models.ShowSeat;
import com.scaler.MovieBooking.repository.ShowSeatRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ShowSeatService {
    private ShowSeatRepository showSeatRepository;

    public void create(List<ShowSeat> showSeats) {
        showSeatRepository.saveAll(showSeats);
    }
}
