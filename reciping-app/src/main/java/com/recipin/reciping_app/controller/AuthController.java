package com.recipin.reciping_app.controller;

import com.recipin.reciping_app.dto.JwtResponse;
import com.recipin.reciping_app.dto.LoginRequest;
import com.recipin.reciping_app.dto.UserDto;
import com.recipin.reciping_app.model.User;
import com.recipin.reciping_app.service.JwtService;
import com.recipin.reciping_app.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    @Autowired
    private UserService userService;

    @Autowired
    private JwtService jwtService;

    // REGISTER
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserDto userDto) {
        if (userService.emailExists(userDto.getEmail())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Email is already in use.");
        }
        User newUser = userService.createUser(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }
    // REGISTER
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest userReq) {

        try {
            User user = userService.authenticateUser(userReq);
            String jwtToken = jwtService.generateToken(user);
            return ResponseEntity.ok(new JwtResponse(jwtToken, user));

//        } catch (UsernameNotFoundException | BadCredentialsException ex) {
        } catch (Exception ex) {
            if(ex instanceof UsernameNotFoundException || ex instanceof BadCredentialsException){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Credentials");
            }else {
                ex.printStackTrace();
                return ResponseEntity
                        .status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("Error at Login");
            }
        }
    }
}
