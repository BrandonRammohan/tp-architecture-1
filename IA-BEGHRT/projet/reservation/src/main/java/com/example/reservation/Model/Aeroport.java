package com.example.reservation.Model;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Aeroport {

    @JsonProperty("areroportId")
    private int areroportId;

    @JsonProperty("nom_Aeroport")
    private String nom_Aeroport;

    @JsonProperty("code_Aeroport")
    private String code_Aeroport;


    public int getAreroportId() {
        return areroportId;
    }

    public void setAreroportId(int areroportId) {
        this.areroportId = areroportId;
    }

    public String getNom_Aeroport() {
        return nom_Aeroport;
    }

    public void setNom_Aeroport(String nom_Aeroport) {
        this.nom_Aeroport = nom_Aeroport;
    }

    public String getCode_Aeroport() {
        return code_Aeroport;
    }

    public void setCode_Aeroport(String code_Aeroport) {
        this.code_Aeroport = code_Aeroport;
    }
}
