package com.scaler.MovieBooking.repository;

import com.scaler.MovieBooking.models.Screen;
import com.scaler.MovieBooking.models.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScreenRepository extends JpaRepository<Screen, Integer> {


}
