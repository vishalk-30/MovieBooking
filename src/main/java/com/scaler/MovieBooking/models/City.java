package com.scaler.MovieBooking.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class City extends BaseModel {

    private String name;

    @OneToMany
    private List<Theatre> theatres = new ArrayList<>();
}
