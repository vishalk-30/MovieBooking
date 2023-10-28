package com.scaler.MovieBooking.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer extends BaseModel{
    private String fullName;
    private String city;
    private String phoneNumber;
    private String email;
    @OneToOne
    private User user;

}
