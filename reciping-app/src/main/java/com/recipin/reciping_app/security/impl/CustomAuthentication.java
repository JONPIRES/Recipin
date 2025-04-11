package com.recipin.reciping_app.security.impl;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class CustomAuthentication implements Authentication {

    private final String username;
    private boolean authenticated = true; // You can set it to false based on your validation logic

    public CustomAuthentication(String username) {
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null; // You can return a list of roles if required
    }

    @Override
    public Object getCredentials() {
        return null; // Typically return a password or token here
    }

    @Override
    public Object getDetails() {
        return null; // You can return more user details if needed
    }

    @Override
    public Object getPrincipal() {
        return username; // This is usually the username (or user ID) from the token
    }

    @Override
    public boolean isAuthenticated() {
        return authenticated; // This is based on your validation logic
    }

    @Override
    public void setAuthenticated(boolean authenticated) throws IllegalArgumentException {
        this.authenticated = authenticated;
    }

    @Override
    public String getName() {
        return username; // Typically, this would return the user's name
    }
}
