package com.scaler.MovieBooking.controller;

import com.scaler.MovieBooking.dto.CreateMovieDTO;
import com.scaler.MovieBooking.models.Movie;
import com.scaler.MovieBooking.service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movie")
@AllArgsConstructor
public class MovieController {
    private MovieService movieService;

    @PostMapping
    public Movie createMovie (@RequestBody CreateMovieDTO movieRequest ){

        return movieService.createMovie(movieRequest.toMovie());
    }

    @GetMapping("/{movieId}")
    public Movie getMovie(@PathVariable int movieId){
        return movieService.getMovie(movieId);
    }


}
