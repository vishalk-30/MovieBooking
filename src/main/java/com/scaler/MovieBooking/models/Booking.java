package com.scaler.MovieBooking.models;

import com.scaler.MovieBooking.enums.BookingStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Entity
public class Booking extends BaseModel{
    @ManyToOne
    private Customer customer
            ;

    @ManyToOne
    private Show show;
    @ManyToMany
    private List<ShowSeat> showSeats = new ArrayList<>();

    private Double amount;
    private Date bookedDate;
    private BookingStatus bookingStatus;

    @OneToMany
    private List<Payment> payments = new ArrayList<>();
}
