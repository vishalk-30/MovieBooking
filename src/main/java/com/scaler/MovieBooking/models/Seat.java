package com.scaler.MovieBooking.models;

import com.scaler.MovieBooking.enums.SeatType;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Seat extends BaseModel {

    private int rowNo;
    private int colNo;

    @Enumerated
    private SeatType seatType;

    @ManyToOne
    private Screen screen;
}
