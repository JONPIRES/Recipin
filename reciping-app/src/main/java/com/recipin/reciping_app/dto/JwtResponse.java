package com.recipin.reciping_app.dto;

import com.recipin.reciping_app.model.User;

public class JwtResponse {

    private String token;
    private String email;
    private String name;

    public JwtResponse(String token, User user) {
        this.token = token;
        this.email = user.getEmail();
        this.name = user.getFirstName() + " " + user.getLastName();
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
