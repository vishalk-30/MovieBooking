package com.scaler.MovieBooking.models;

import com.scaler.MovieBooking.enums.MovieFeature;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Screen extends BaseModel {

    private String name;
    @OneToMany
    private List<Seat> seats = new ArrayList<>();
    @ElementCollection
    @Enumerated
    private List<MovieFeature> features = new ArrayList<>();
}
