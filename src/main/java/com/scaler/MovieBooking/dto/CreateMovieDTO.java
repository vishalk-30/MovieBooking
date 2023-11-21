package com.scaler.MovieBooking.dto;

import com.scaler.MovieBooking.enums.Language;
import com.scaler.MovieBooking.enums.MovieFeature;
import com.scaler.MovieBooking.models.Movie;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@Getter
public class CreateMovieDTO {
    private String name;
    private Double rating;
    private List<Language> languages;
    private List<MovieFeature> features;

    public Movie toMovie(){
        return Movie.builder()
                .name(name)
                .rating(rating)
                .features(features)
                .languages(languages)
                .build();

    }
}
