package com.example.reservation.JsonAccess;

import com.example.reservation.Model.Aeroport;
import com.example.reservation.Model.User;
import com.example.reservation.Model.Vol;

public interface JsonService {

    public Aeroport[] stringToJsonAirports(String PathJson) throws Exception;
    public Vol[] stringToJsonVols(String PathJson) throws Exception;
    public User[] stringToJsonUsers(String PathJson) throws Exception;
    public User addUser(String email) throws Exception;
}
