package com.scaler.MovieBooking.service;

import com.scaler.MovieBooking.models.Seat;
import com.scaler.MovieBooking.repository.SeatRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SeatService {
    private SeatRepository seatRepository;

    public List<Seat> getAll(int screenId){
        return seatRepository.findAllByScreen_Id(screenId);
    }

    public Seat createSeat(Seat seat){
        return seatRepository.save(seat);
    }
}
