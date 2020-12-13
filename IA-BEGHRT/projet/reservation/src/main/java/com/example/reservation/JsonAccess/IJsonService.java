package com.example.reservation.JsonAccess;

import com.example.reservation.Model.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

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

    public Reservation[] stringToJsonReservation(String PathJson) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        Reservation[] myObjects = mapper.readValue(readFileAsString(PathJson), Reservation[].class);
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

    public void addReservation(int volId, int userId) throws Exception {

        RandomAccessFile randomAccessFile = new RandomAccessFile("src/main/resources/Json/reservation.json", "rw");
        long pos = randomAccessFile.length();
        while (randomAccessFile.length() > 0) {
            pos--;
            randomAccessFile.seek(pos);
            if (randomAccessFile.readByte() == ']') {
                randomAccessFile.seek(pos);
                break;
            }
        }

        String PathJsonVols="src/main/resources/Json/vol.json";
        String PathJson="src/main/resources/Json/reservation.json";

        Reservation reservations[] = this.stringToJsonReservation(PathJson);
        int reservation_id =  reservations.length + 1;

        String jsonElement = "{ \"reservationId\":" + reservation_id + ", \n" +
                " \"userId\":" +  + userId + ", \n" +
                " \"volId\":" +  + volId + "\n}";

        if(readFileAsString(PathJson).equals("[\n\n]")){
            randomAccessFile.writeBytes(jsonElement + "\n]");
        } else{
            randomAccessFile.writeBytes(",\n" + jsonElement + "]");
        }
        randomAccessFile.close();
        }

        public List<ReservationFront> getReservationFront(User activUser) throws Exception {

            String airportfile = "src/main/resources/Json/aeroport.json";
            String volfile = "src/main/resources/Json/vol.json";
            String reservationfile = "src/main/resources/Json/reservation.json";
            String userfile = "src/main/resources/Json/user.json";

            Aeroport aeroports[] = this.stringToJsonAirports(airportfile);
            Vol vols[] = this.stringToJsonVols(volfile);
            User users[] = this.stringToJsonUsers(userfile);
            Reservation reservations[] = this.stringToJsonReservation(reservationfile);
            List<ReservationFront> rFront = new ArrayList<>();
            List<VolFront> vFront = new ArrayList<>();

            for(Reservation elem : reservations) {
                //User
                Optional<User> tmpUsr = Arrays.stream(users).filter(user -> user.getUserId() == elem.getUserId()).findAny();
                User usrtmp1 = new User();
                usrtmp1.setEmail(tmpUsr.get().getEmail());
                usrtmp1.setUserId(tmpUsr.get().getUserId());

                if (usrtmp1.getUserId() == activUser.getUserId()) {
                    //Vol
                    Optional<Vol> tmpVol = Arrays.stream(vols).filter(vol -> vol.getVolId() == elem.getVolId()).findAny();
                    Vol volTmp1 = new Vol();

                    //VolFront //Aeroport Depart
                    Optional<Aeroport> tmpAirportDepart = Arrays.stream(aeroports).filter(airport -> airport.getAreroportId()
                            == tmpVol.get().getAeroportId_depart()).findAny();

                    //VolFront //Aeroport Arrivée
                    Optional<Aeroport> tmpAirportArrive = Arrays.stream(aeroports).filter(airport -> airport.getAreroportId()
                            == tmpVol.get().getAeroportId_arrive()).findAny();

                    VolFront volFrontTmp = new VolFront();

                    volFrontTmp.setVolId(tmpVol.get().getVolId());
                    volFrontTmp.setAeroportId_arrive(tmpAirportDepart.get());
                    volFrontTmp.setAeroportId_depart(tmpAirportArrive.get());
                    volFrontTmp.setDate(tmpVol.get().getDate());
                    volFrontTmp.setNb_place_libre(tmpVol.get().getNb_place_libre());
                    volFrontTmp.setStatus(tmpVol.get().getStatus());
                    volFrontTmp.setPrix(tmpVol.get().getPrix());

                    //Reservationn Front
                    ReservationFront tmpRf = new ReservationFront();
                    tmpRf.setUser(usrtmp1);
                    tmpRf.setVol(volFrontTmp);

                    //On le add dans le Reservation Front
                    rFront.add(tmpRf);
                }
            }
            return rFront;
        }

    public List<VolFront> getVolsFront(User activUser) throws Exception {

        String airportfile = "src/main/resources/Json/aeroport.json";
        String volfile = "src/main/resources/Json/vol.json";

        Aeroport aeroports[] = this.stringToJsonAirports(airportfile);
        Vol vols[] = this.stringToJsonVols(volfile);
        List<VolFront> vFront = new ArrayList<>();

        for (Vol elem : vols) {
            //Vol
            Optional<Vol> tmpVol = Arrays.stream(vols).filter(vol -> vol.getVolId() == elem.getVolId()).findAny();
            Vol volTmp1 = new Vol();

            //VolFront //Aeroport Depart
            Optional<Aeroport> tmpAirportDepart = Arrays.stream(aeroports).filter(airport -> airport.getAreroportId()
                    == tmpVol.get().getAeroportId_depart()).findAny();

            //VolFront //Aeroport Arrivée
            Optional<Aeroport> tmpAirportArrive = Arrays.stream(aeroports).filter(airport -> airport.getAreroportId()
                    == tmpVol.get().getAeroportId_arrive()).findAny();

            VolFront volFrontTmp = new VolFront();

            volFrontTmp.setVolId(tmpVol.get().getVolId());
            volFrontTmp.setAeroportId_arrive(tmpAirportDepart.get());
            volFrontTmp.setAeroportId_depart(tmpAirportArrive.get());
            volFrontTmp.setDate(tmpVol.get().getDate());
            volFrontTmp.setNb_place_libre(tmpVol.get().getNb_place_libre());
            volFrontTmp.setStatus(tmpVol.get().getStatus());
            volFrontTmp.setPrix(tmpVol.get().getPrix());

            //On le add dans le Reservation Front
            vFront.add(volFrontTmp);
        }
        return vFront;
    }
}
