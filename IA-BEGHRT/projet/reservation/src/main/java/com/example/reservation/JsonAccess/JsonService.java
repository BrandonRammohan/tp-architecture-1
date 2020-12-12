package com.example.reservation.JsonAccess;

import com.example.reservation.Model.Aeroport;

public interface JsonService {

    public Aeroport[] stringToJsonAirports(String PathJson) throws Exception;

}
