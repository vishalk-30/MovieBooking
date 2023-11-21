package com.scaler.MovieBooking.repository;

import com.scaler.MovieBooking.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Integer> {
    Optional<Movie> findMovieByName(String name);
}
