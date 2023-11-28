package com.scaler.MovieBooking.controller;

import com.scaler.MovieBooking.dto.CreateBookingDTO;
import com.scaler.MovieBooking.models.Booking;
import com.scaler.MovieBooking.service.BookingService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/booking")
@AllArgsConstructor
public class BookingController {
    private BookingService bookingService;
    @PostMapping
    public Booking createBooking(@RequestBody CreateBookingDTO bookingRequest){
        return bookingService.createBooking(bookingRequest);

    }
}
