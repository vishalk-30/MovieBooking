package com.scaler.MovieBooking.models;

import com.scaler.MovieBooking.models.constant.BaseModel;
import com.scaler.MovieBooking.models.constant.MovieFeature;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Movie extends BaseModel {
    private String name;
    private String description;
    private String language;
    @ManyToMany
    private List<Actor> actors;
    @Enumerated(EnumType.STRING)
    private List<MovieFeature> movieFeatures;
}
