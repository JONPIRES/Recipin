package com.recipin.reciping_app.service;
import com.recipin.reciping_app.dto.LoginRequest;
import com.recipin.reciping_app.model.User;
import io.jsonwebtoken.Claims;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;


public interface JwtService {

    Key getSignInKey();
    String generateToken(User userDetails);
    String generateToken(Map<String, Object> extraClaims, User user);
    String extractUsername(String token);
    <T> T extractClaim(String token, Function<Claims, T> claimsResolver);
    Claims extractAllClaims(String token);
    Date extractExpiration(String token);
    boolean isTokenValid(String token, UserDetails userDetails);
    boolean isTokenExpired(String token);
}
