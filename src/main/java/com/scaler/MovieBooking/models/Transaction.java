package com.scaler.MovieBooking.models;

import com.scaler.MovieBooking.models.constant.BaseModel;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Transaction extends BaseModel {
    @ManyToOne
    private Payment payment;

}
