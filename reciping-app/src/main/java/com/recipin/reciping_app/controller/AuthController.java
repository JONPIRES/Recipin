package com.recipin.reciping_app.controller;

import com.recipin.reciping_app.dto.LoginRequest;
import com.recipin.reciping_app.dto.UserDto;
import com.recipin.reciping_app.model.Ingredient;
import com.recipin.reciping_app.model.User;
import com.recipin.reciping_app.repository.IngredientRepository;
import com.recipin.reciping_app.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    @Autowired
    private UserService userService;

    // 🔐 REGISTER
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserDto userDto) {
        if (userService.emailExists(userDto.getEmail())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Email is already in use.");
        }
        User newUser = userService.createUser(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }
}
