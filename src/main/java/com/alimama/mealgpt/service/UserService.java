package com.alimama.mealgpt.service;

import com.alimama.mealgpt.entity.User;
import com.alimama.mealgpt.entity.WebUser;
import com.alimama.mealgpt.pojo.LoginRequest;
import com.alimama.mealgpt.pojo.LoginResponse;
import com.alimama.mealgpt.pojo.RegisterRequest;
import com.alimama.mealgpt.pojo.RegisterResponse;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService {
    void save(RegisterRequest registerRequest);

    User findByUserName(String userName);

    LoginResponse login(LoginRequest loginRequest);

    RegisterResponse register(RegisterRequest registerRequest);
}
