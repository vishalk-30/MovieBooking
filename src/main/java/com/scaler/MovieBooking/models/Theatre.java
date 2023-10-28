package com.scaler.MovieBooking.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Theatre extends BaseModel {

    private String name;
    private String address;

    @OneToMany
    List<Screen> screens = new ArrayList<>();

    @OneToMany
    List<Show> shows = new ArrayList<>();
}
