package com.example.reservation.JsonAccess;

import com.example.reservation.Model.Aeroport;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Service
public class IJsonService implements JsonService {

    public Aeroport[] stringToJsonAirports(String PathJson) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        Aeroport[] myObjects = mapper.readValue(readFileAsString(PathJson), Aeroport[].class);
        return myObjects;
    }

    public static String readFileAsString(String file)throws Exception
    {
        return new String(Files.readAllBytes(Paths.get(file)));
    }
}
