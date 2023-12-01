package com.scaler.MovieBooking.dto;

import com.scaler.MovieBooking.enums.MovieFeature;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class CreateTheatreDTO {
    private String name;
    private String address;
    private int row;
    private int col;
    private List<MovieFeature> features;
}
