package com.scaler.MovieBooking.repository;

import com.scaler.MovieBooking.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking,Integer> {
}
