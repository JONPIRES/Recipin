package com.recipin.reciping_app.security.impl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.Nullable;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.crypto.SecretKey;
import java.io.IOException;
import java.util.Arrays;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Value("${jwt.secret}")
    private String secretKey;
    // Convert the secret key into a secure Key object
    private SecretKey getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey); // `secretKey` is your base64 string
        return Keys.hmacShaKeyFor(keyBytes);
    }


    private String getJwtFromRequest(HttpServletRequest request) {
        logger.info(String.format("authorization header: %s", request.getHeader("Authorization")));
        String bearerToken = request.getHeader("Authorization");

        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7); // Extract the token from the header
        }
        return null; // Return null if no token is found
    }

    private boolean validateToken(String token) {
        try {
//            logger.info(String.format("Validating token: %s", token));
            // Validate the token by parsing it with the signing key
            Jwts.parser()
                    .verifyWith(getSigningKey())
                    .build()
                    .parseSignedClaims(token);
            return true;
        } catch (Exception e) {
            return false; // If validation fails, return false
        }
    }

    private Authentication getAuthentication(String token) {
        Claims claims = Jwts.parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();

        String username = claims.getSubject(); // Extract the username (or other information)

        // Assuming you have a method to get the user details from your service
        return new CustomAuthentication(username); // Use your custom authentication object
    }

@Override
protected void doFilterInternal(@Nullable HttpServletRequest request,
                                @Nullable HttpServletResponse response,
                                @Nullable FilterChain filterChain) throws ServletException, IOException {

    if (request != null && filterChain != null) {

        String path = request.getServletPath();
        if (path.equals("/api/user/login") || path.equals("/api/user/register") || path.startsWith("/api/auth")) {
            filterChain.doFilter(request, response);
            return;
        }
        String token = getJwtFromRequest(request);

//        TODO: Getting an error here
        if (token != null && validateToken(token)) {
            Authentication authentication = getAuthentication(token);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        // Continue the request-response cycle
        filterChain.doFilter(request, response);
    } else {
        if (response != null) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("Req is missing.");
        } else {
            throw new ServletException("Req and Res are both null.");
        }
    }
}
}
