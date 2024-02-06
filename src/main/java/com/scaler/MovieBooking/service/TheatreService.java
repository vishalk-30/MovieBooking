package com.scaler.MovieBooking.service;

import com.scaler.MovieBooking.dto.CreateTheatreDTO;
import com.scaler.MovieBooking.exception.TheatreNotFoundException;
import com.scaler.MovieBooking.models.Screen;
import com.scaler.MovieBooking.models.Theatre;
import com.scaler.MovieBooking.repository.TheatreRepository;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class TheatreService {
    TheatreRepository theatreRepository;
    ScreenService screenService;
    public Theatre getTheatre(Integer id) {
        return theatreRepository.findById(id)
                .orElseThrow(() -> new TheatreNotFoundException("Theatre not found for the id: " + id));
    }

    public Theatre createTheatre(CreateTheatreDTO theatreDTO) {
        List<Screen> screens = new ArrayList<>();
        for(int screenId: theatreDTO.getScreenId()){
            screens.add(screenService.getScreenInternal(screenId));
        }
        Theatre theatre =Theatre.builder()
                .address(theatreDTO.getAddress())
                .name(theatreDTO.getName())
                .screens(screens)
                .build();
        return theatreRepository.save(theatre);
    }
}
