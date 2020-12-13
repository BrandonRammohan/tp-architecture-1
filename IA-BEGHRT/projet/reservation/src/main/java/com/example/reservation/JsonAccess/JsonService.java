package com.example.reservation.JsonAccess;

import com.example.reservation.Model.*;

import java.util.List;

public interface JsonService {

    Aeroport[] stringToJsonAirports(String PathJson) throws Exception;
    Vol[] stringToJsonVols(String PathJson) throws Exception;
    User[] stringToJsonUsers(String PathJson) throws Exception;
    Reservation[] stringToJsonReservation(String userfile) throws Exception;
    User addUser(String email) throws Exception;
    void addReservation(int volId, int userId) throws Exception;
    List<ReservationFront> getReservationFront(User activUser) throws Exception;
    List<VolFront> getVolsFront(User activUser) throws Exception;

}
