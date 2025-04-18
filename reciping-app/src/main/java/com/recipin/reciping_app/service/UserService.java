package com.recipin.reciping_app.service;
import com.recipin.reciping_app.dto.LoginRequest;
import com.recipin.reciping_app.dto.UserDto;
import com.recipin.reciping_app.model.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserService {

    boolean emailExists(String email);
    User createUser(UserDto userDto);
    User getLoggedInUser(UserDto userDto);
    List<User> getAllUsers();
    void deleteUser(Long id);


}
