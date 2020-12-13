package com.example.reservation.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ReservationFront {

    private int reservationId;

    private User user;

    private VolFront vol;

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public VolFront getVol() {
        return vol;
    }

    public void setVol(VolFront vol) {
        this.vol = vol;
    }
}
