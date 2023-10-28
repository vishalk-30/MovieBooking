package com.scaler.MovieBooking.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "users")

public class User extends BaseModel {
    private String name;
    private String email;
    private String password;

//    @OneToMany
   // private List<Ticket> tickets;
}
