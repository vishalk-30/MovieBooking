package com.scaler.MovieBooking.controller;

import com.scaler.MovieBooking.dto.CreateTheatreDTO;
import com.scaler.MovieBooking.models.Theatre;
import com.scaler.MovieBooking.service.TheatreService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("theatres")
@AllArgsConstructor
public class TheatreController {
    private TheatreService theatreService;
    @GetMapping("{id}")
    public Theatre getTheatre(@PathVariable Integer id){
        return theatreService.getTheatre(id);
    }
    @PostMapping
    public  Theatre createTheatre(@RequestBody CreateTheatreDTO theatreDTO){
        return theatreService.createTheatre(theatreDTO);

    }


}
