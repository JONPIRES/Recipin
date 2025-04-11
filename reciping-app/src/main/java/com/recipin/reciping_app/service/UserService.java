package com.recipin.reciping_app.service;
import com.recipin.reciping_app.dto.UserDto;
import com.recipin.reciping_app.model.User;

import java.util.List;

public interface UserService {

    boolean emailExists(String email);
    User createUser(UserDto userDto);
    List<User> getAllUsers();
    void deleteUser(Long id);



}
