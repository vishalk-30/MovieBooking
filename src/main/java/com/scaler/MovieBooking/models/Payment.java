package com.scaler.MovieBooking.models;

import com.scaler.MovieBooking.enums.PaymentMethodType;
import com.scaler.MovieBooking.enums.PaymentStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Payment extends BaseModel{
    private String reference;
    private Double amount;
    @Enumerated
    private PaymentMethodType paymentMethod;
    @Enumerated
    private PaymentStatus paymentStatus;
}
