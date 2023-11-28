package com.scaler.MovieBooking.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@Getter
public class CreateBookingDTO {
    private int customerId;
    private int showId;
    private List<Integer> showSeatId = new ArrayList<>();

}
