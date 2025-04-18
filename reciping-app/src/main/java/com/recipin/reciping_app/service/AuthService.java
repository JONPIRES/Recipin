package com.recipin.reciping_app.service;
import com.recipin.reciping_app.dto.LoginRequest;
import com.recipin.reciping_app.dto.UserDto;
import com.recipin.reciping_app.model.User;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface AuthService {

    User authenticateUser(LoginRequest user);
}
