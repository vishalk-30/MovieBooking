package com.scaler.MovieBooking.models;

import com.scaler.MovieBooking.models.constant.AuditoriumFeatures;
import com.scaler.MovieBooking.models.constant.BaseModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Auditorium extends BaseModel {
    private String name;
    private int capacity;

    @OneToMany
    private List<Show> shows;

    @OneToMany
    private List<Seat> seats;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<AuditoriumFeatures> auditoriumFeatures;

}
