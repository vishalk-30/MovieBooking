package com.scaler.MovieBooking.service;

import com.scaler.MovieBooking.dto.CreateScreenDTO;
import com.scaler.MovieBooking.enums.SeatType;
import com.scaler.MovieBooking.exception.ScreenNotFoundException;
import com.scaler.MovieBooking.models.Screen;
import com.scaler.MovieBooking.models.Seat;
import com.scaler.MovieBooking.repository.ScreenRepository;
import com.scaler.MovieBooking.repository.SeatRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ScreenService {

    ScreenRepository screenRepository;
    SeatService seatService;

    public Screen getScreenInternal(int id){
        return screenRepository.findById(id).orElse(null);

    }

    public Screen getScreen(Integer id) {
        return screenRepository.findById(id)
                .orElseThrow(() -> new ScreenNotFoundException("Screen not found for the id:"+ id));
    }

    public Screen createScreen(CreateScreenDTO screenDTO) {
        Screen screen = Screen.builder()
                .name(screenDTO.getScreenName())
                .build();

        List<Seat> seats = new ArrayList<>();
        for (int i = 0; i < screenDTO.getTotalRow(); i++) {
            for (int j = 0; j < screenDTO.getTotalCol(); j++) {
                Seat seat = Seat.builder()
                        .rowNo(i)
                        .colNo(j)
                        .seatType(SeatType.SILVER)
                        .build();
                seatService.createSeat(seat);
                seats.add(seat);

            }


        }
        screen = screen.toBuilder().seats(seats).build();
        return screenRepository.save(screen);
    }

    }
