package com.scaler.MovieBooking.models;

import com.scaler.MovieBooking.enums.Language;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Entity(name = "shows")
public class Show extends BaseModel{
    @ManyToOne
    private Movie movie;
    private Date startTime;
    private int duration;
    @OneToMany
    private List<ShowSeat> showSeats = new ArrayList<>();
    @ManyToOne
    private Screen screen;
    @Enumerated
    private Language language;



}
