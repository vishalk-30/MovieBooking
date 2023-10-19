package com.scaler.MovieBooking.models;

import com.scaler.MovieBooking.models.constant.BaseModel;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Theatre extends BaseModel {
    private String name;
    private String address;

    @OneToMany
    private List<Auditorium> auditoriums;


}
