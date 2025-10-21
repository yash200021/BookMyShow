package com.example.bookmyshow.models;

import com.example.bookmyshow.models.enums.ShowSeatStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ShowSeat extends BaseModel {
    @ManyToOne
    private Show show;
    @ManyToOne
    private Seat seat;
    @Enumerated(EnumType.ORDINAL)
    private ShowSeatStatus showSeatStatus;
}

/*
(S1A1, s1A2, s1A3, S2A1, S2A2)
1               1
ShowSeat   --> Show   ---> m:1
m               1

1               1
showSeat   --> Seat   --->  m:1
m               1
 */
