package com.scaler.MovieBooking.controller;

import com.scaler.MovieBooking.dto.CreateScreenDTO;
import com.scaler.MovieBooking.models.Screen;
import com.scaler.MovieBooking.service.ScreenService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/screen")
@AllArgsConstructor
public class ScreenController {
    private ScreenService screenService;
    @GetMapping("/{id}")
    public Screen getScreen(@PathVariable Integer id){
        return screenService.getScreen(id);
    }

    @PostMapping
    public Screen createScreen(@RequestBody CreateScreenDTO screenDTO){
        return screenService.createScreen(screenDTO);
    }




}
