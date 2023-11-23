package com.scaler.MovieBooking.repository;

import com.scaler.MovieBooking.models.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeatRepository extends JpaRepository<Seat, Integer> {
    List<Seat> findAllByScreen_Id(int screenId);
}
