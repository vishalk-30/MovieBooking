package com.scaler.MovieBooking.controller;

import com.scaler.MovieBooking.dto.CreateShowDTO;
import com.scaler.MovieBooking.models.Show;
import com.scaler.MovieBooking.service.ShowService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/show")
@AllArgsConstructor
public class ShowController {

    private ShowService showService;

    @PostMapping()
    public Show createShow(@RequestBody CreateShowDTO request){
        return showService.createShow(request);

    }

    @GetMapping("/{id}")
    public Show getShow(@PathVariable int id){
        return showService.getShow(id);

    }
}
