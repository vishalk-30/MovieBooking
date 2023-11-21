package com.scaler.MovieBooking.dto;

import com.scaler.MovieBooking.models.Booking;
import com.scaler.MovieBooking.models.User;
import lombok.AllArgsConstructor;

import java.util.List;
@AllArgsConstructor
public class GetCustomerDTO {
    private String fullName;
    private String city;
    private String phoneNumber;
    private String email;
    private User user;
}
