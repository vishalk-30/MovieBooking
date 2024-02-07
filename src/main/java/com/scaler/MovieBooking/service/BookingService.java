package com.scaler.MovieBooking.service;

import com.scaler.MovieBooking.dto.CreateBookingDTO;
import com.scaler.MovieBooking.enums.BookingStatus;
import com.scaler.MovieBooking.enums.SeatStatus;
import com.scaler.MovieBooking.exception.AlreadyBookedException;
import com.scaler.MovieBooking.models.Booking;
import com.scaler.MovieBooking.models.Customer;
import com.scaler.MovieBooking.models.Show;
import com.scaler.MovieBooking.models.ShowSeat;
import com.scaler.MovieBooking.repository.BookingRepository;
import com.scaler.MovieBooking.strategies.PricingStrategy;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;


@Service
@AllArgsConstructor
public class BookingService {
    private BookingRepository bookingRepository;
    private CustomerService customerService;
    private ShowService showService;
    private ShowSeatService showSeatService;
    @Qualifier("seatBasedStrategy")
    private PricingStrategy pricingStrategy;
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Booking createBooking(CreateBookingDTO bookingRequest){

        // validate customer
        Customer customer = customerService.getCustomer(bookingRequest.getCustomerId());
        if(customer == null){
            throw new NoSuchElementException("Customer doesn't exist: " + bookingRequest.getCustomerId());
        }

        // validate show
        Show show = showService.getShowInternal(bookingRequest.getShowId());
        if(show == null){
            throw new NoSuchElementException("Show doesn't exist: " + bookingRequest.getShowId());
        }

        // validate show seats

        List<ShowSeat> showSeats = showSeatService.getShowSeatInternal(bookingRequest.getShowSeatId());
        // check if they are available or not

        for (ShowSeat showSeat: showSeats){
            if(showSeat.getSeatStatus() != SeatStatus.AVAILABLE){
                throw new AlreadyBookedException("Seat Already Booked: " + showSeat.getSeat().getId());
            }
        }

        // if available mark the seats as locked
        /*List<ShowSeat> lockedSeats = showSeats.stream().map(seat -> showSeats.toBuilder()
                .seatStatus(SeatStatus.LOCKED)
                .build()).toList();*/
        List<ShowSeat> lockedSeats = new ArrayList<>();
        for(ShowSeat seat: showSeats){
            seat.setSeatStatus(SeatStatus.LOCKED);
            lockedSeats.add(seat);

        }

        showSeatService.saveAll(lockedSeats);



        Booking booking = Booking.builder()
                .customer(customer)
                .show(show)
                .bookedDate(new Date())
                .bookingStatus(BookingStatus.PENDING)
                .build();

        Double amount = pricingStrategy.calculatePrice(booking,lockedSeats);
        Booking withAmount = booking.toBuilder().amount(amount).build();
        return bookingRepository.save(withAmount);

    }
}
