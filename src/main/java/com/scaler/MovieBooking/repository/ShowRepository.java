package com.scaler.MovieBooking.repository;

import com.scaler.MovieBooking.models.Show;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowRepository extends JpaRepository<Show, Integer> {
}
