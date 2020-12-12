package com.example.reservation.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Reservation {

    @JsonProperty("reservationId")
    private int reservationId;

    @JsonProperty("userId")
    private int userId;

    @JsonProperty("volId")
    private int volId;

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getVolId() {
        return volId;
    }

    public void setVolId(int volId) {
        this.volId = volId;
    }
}
