package com.example.reservation.JsonAccess;

import com.example.reservation.Model.Aeroport;
import com.example.reservation.Model.User;
import com.example.reservation.Model.Vol;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
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

    public Vol[] stringToJsonVols(String PathJson) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        Vol[] myObjects = mapper.readValue(readFileAsString(PathJson), Vol[].class);
        return myObjects;
    }

    public User[] stringToJsonUsers(String PathJson) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        User[] myObjects = mapper.readValue(readFileAsString(PathJson), User[].class);
        return myObjects;
    }

    public static String readFileAsString(String file)throws Exception
    {
        return new String(Files.readAllBytes(Paths.get(file)));
    }

    public Aeroport getAirportById(int id, Aeroport[] aeroports) {
        for (Aeroport elem : aeroports) {
            if (elem.getAreroportId() == id) {
                return elem;
            }
        }
        return null;
    }

    public User addUser(String email) throws Exception {

        User user = new User();
        user.setEmail(email);

        if(!readFileAsString("src/main/resources/Json/user.json").contains(email)) {

            RandomAccessFile randomAccessFile = new RandomAccessFile("src/main/resources/Json/user.json", "rw");
            long pos = randomAccessFile.length();
            while (randomAccessFile.length() > 0) {
                pos--;
                randomAccessFile.seek(pos);
                if (randomAccessFile.readByte() == ']') {
                    randomAccessFile.seek(pos);
                    break;
                }
            }

            String PathJson="src/main/resources/Json/user.json";

            User users[] = this.stringToJsonUsers(PathJson);
            int user_id =  users.length + 1;
            user.setUserId(user_id);

            String jsonElement = "{ \"userId\":" + user_id + ", \n" +
                    " \"email\":" + "\"" + email + "\"" +  "\n}";

            if(readFileAsString(PathJson).equals("[\n\n]")){
                randomAccessFile.writeBytes(jsonElement + "\n]");
            } else{
                randomAccessFile.writeBytes(",\n" + jsonElement + "]");
            }
            randomAccessFile.close();
        }
        else {
            String PathJson="src/main/resources/Json/user.json";
            User users[] = this.stringToJsonUsers(PathJson);
            for( User elem : users) {
                if(elem.getEmail().equals(email)){
                    user.setUserId(elem.getUserId());
                }
            }

        }

        return user;

    }

}
