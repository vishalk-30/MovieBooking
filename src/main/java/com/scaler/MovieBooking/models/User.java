package com.scaler.MovieBooking.models;

import com.scaler.MovieBooking.models.constant.BaseModel;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.prefs.BackingStoreException;
@Getter
@Setter
@Entity
public class User extends BaseModel {
    private String name;
    private String email;
    @OneToMany
    private List<Ticket> tickets;
}
