package com.scaler.MovieBooking.service;

import com.scaler.MovieBooking.exception.MovieAlreadyExistException;
import com.scaler.MovieBooking.exception.MovieNotFoundException;
import com.scaler.MovieBooking.models.Movie;
import com.scaler.MovieBooking.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class MovieService {
    MovieRepository movieRepository;
    public Movie createMovie(Movie movie){

        // validate if movie is present
        Optional<Movie> existingMovie = movieRepository.findMovieByName(movie.getName());
        // if throw Exception
        if(existingMovie.isPresent()){
            throw new MovieAlreadyExistException(" Movie Already Exist " + movie.getName());
        }
        return movieRepository.save(movie);


    }

    public Movie getMovie(int movieId){
        return   movieRepository
                .findById(movieId)
                .orElseThrow(() -> new MovieNotFoundException("Movie Not Found for the id: " + movieId));

    }
}
