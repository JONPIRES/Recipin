package com.recipin.reciping_app.service.impl;

import com.recipin.reciping_app.dto.LoginRequest;
import com.recipin.reciping_app.dto.UserDto;
import com.recipin.reciping_app.model.User;
import com.recipin.reciping_app.repository.UserRepository;
import com.recipin.reciping_app.security.impl.CustomUserDetailsService;
import com.recipin.reciping_app.service.AuthService;
import com.recipin.reciping_app.service.JwtService;
import com.recipin.reciping_app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepo;
    private final PasswordEncoder passwordEncoder;



    @Autowired
    public AuthServiceImpl(UserRepository userRepo, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, JwtService jwtService, CustomUserDetailsService userDetailsService, UserRepository userRepo1, PasswordEncoder passwordEncoder1) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder1;
    }

    @Override
    public User authenticateUser(LoginRequest user) {
        Optional<User> userOpt = userRepo.findByEmail(user.getEmail());
        if (userOpt.isEmpty()) {
            throw new UsernameNotFoundException("No user found with email: " + user.getEmail());
        }
        User dbUser = userOpt.get();
        if (!passwordEncoder.matches(user.getPassword(), dbUser.getPassword())) {
            throw new BadCredentialsException("Invalid password");
        }

        return dbUser;
    }
}
