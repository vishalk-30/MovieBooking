package com.scaler.MovieBooking.dto;

import com.scaler.MovieBooking.enums.Language;
import com.scaler.MovieBooking.models.Movie;
import com.scaler.MovieBooking.models.Screen;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@AllArgsConstructor
@Getter
public class CreateShowDTO {
    private int movieId;
    private Date startTime;
    private Language language;
    private int  screenId;
}

