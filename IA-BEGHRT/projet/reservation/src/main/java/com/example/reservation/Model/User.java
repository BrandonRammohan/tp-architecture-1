package com.example.reservation.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

    @JsonProperty("userId")
    private int userId;

    @JsonProperty("email")
    private String email;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
