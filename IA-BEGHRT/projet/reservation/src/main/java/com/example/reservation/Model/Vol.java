package com.example.reservation.Model;

import java.util.Date;

public class Vol {

    private int volId;

    private int aeroportId_depart;

    private int aeroportId_arrive;

    private int prix;

    private Boolean status;

    private Date date;

    private int nb_place_libre;


    public int getVolId() {
        return volId;
    }

    public void setVolId(int volId) {
        this.volId = volId;
    }

    public int getAeroportId_depart() {
        return aeroportId_depart;
    }

    public void setAeroportId_depart(int aeroportId_depart) {
        this.aeroportId_depart = aeroportId_depart;
    }

    public int getAeroportId_arrive() {
        return aeroportId_arrive;
    }

    public void setAeroportId_arrive(int aeroportId_arrive) {
        this.aeroportId_arrive = aeroportId_arrive;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getNb_place_libre() {
        return nb_place_libre;
    }

    public void setNb_place_libre(int nb_place_libre) {
        this.nb_place_libre = nb_place_libre;
    }
}
