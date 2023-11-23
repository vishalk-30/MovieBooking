package com.scaler.MovieBooking.service;

import com.scaler.MovieBooking.models.Screen;
import com.scaler.MovieBooking.repository.ScreenRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ScreenService {

    ScreenRepository screenRepository;

    public Screen getScreenInternal(int id){
        return screenRepository.findById(id).orElse(null);

    }
}
