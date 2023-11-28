package com.scaler.MovieBooking.service;

import com.scaler.MovieBooking.dto.CreateShowDTO;
import com.scaler.MovieBooking.enums.SeatStatus;
import com.scaler.MovieBooking.exception.ShowNotFoundException;
import com.scaler.MovieBooking.models.*;
import com.scaler.MovieBooking.repository.ShowRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class ShowService {
    private ShowRepository showRepository;
    private ScreenService screenService;
    private MovieService movieService;
    private SeatService seatService;
    private ShowSeatService showSeatService;

    public Show createShow(CreateShowDTO request){
        Screen screen = screenService.getScreenInternal(request.getScreenId());
        // validate screen
        if (screen == null){
            throw new NoSuchElementException("Screen doesn't exist for id:" + request.getScreenId());
        }
        // validate movie
        Movie movie = movieService.getMovieInternal(request.getMovieId());
        if(movie == null){
            throw new NoSuchElementException(" Movies doesn't exist for id:" + request.getMovieId());
        }

        // persists the show

        Show show = Show.builder()
                .screen(screen)
                .movie(movie)
                .language(request.getLanguage())
                .startTime(request.getStartTime())
                .build();

        List<Seat> seats = seatService.getAll(screen.getId());
        List<ShowSeat> showSeats = seats.stream().map(
                seat -> ShowSeat.builder()
                        .seat(seat)
                        .show(show)
                        .seatStatus(SeatStatus.AVAILABLE)
                        .build()).toList();

        showSeatService.create(showSeats);
        return show;

    }

    public Show getShow(int id){
        return showRepository
                .findById(id)
                .orElseThrow(() -> new ShowNotFoundException(" Show not found for the id; " +  id));

    }
    public Show getShowInternal(int id){
        return showRepository
                .findById(id)
                .orElse(null);

    }
}
