package com.alimama.mealgpt.service;

import com.alimama.mealgpt.dao.AuthoritiesRepository;
import com.alimama.mealgpt.dao.UserRepository;
import com.alimama.mealgpt.entity.Authorities;
import com.alimama.mealgpt.entity.User;
import com.alimama.mealgpt.entity.WebUser;
import com.alimama.mealgpt.pojo.LoginRequest;
import com.alimama.mealgpt.pojo.LoginResponse;
import com.alimama.mealgpt.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private AuthoritiesRepository authoritiesRepository;

    private BCryptPasswordEncoder passwordEncoder;

    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    public UserServiceImpl(UserRepository theUserRepository, AuthoritiesRepository theAuthoritiesRepository, BCryptPasswordEncoder thePasswordEncoder, JwtTokenProvider jwtTokenProvider) {
        this.userRepository = theUserRepository;
        this.authoritiesRepository = theAuthoritiesRepository;
        this.passwordEncoder = thePasswordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    public LoginResponse login(LoginRequest loginRequest) {

        LoginResponse loginResponse = new LoginResponse();
        User user = userRepository.findUserByUserName(loginRequest.getUserName());

        if (user != null) {
            if (passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())){
                String token = jwtTokenProvider.generateToken(user);
                loginResponse.setToken(token);
                loginResponse.setUserName(user.getUsername());
            }
        }
        return loginResponse;
    }

    @Override
    public void save(WebUser webUser) {
        User user = new User();

        user.setId(webUser.getId());
        user.setUserName(webUser.getUserName());
        user.setPassword(passwordEncoder.encode(webUser.getPassword()));
        user.setPhoneNumber(webUser.getPhoneNumber());
        user.setGender(webUser.getGender());
        user.setEmail(webUser.getEmail());
        userRepository.save(user);
        authoritiesRepository.save(new Authorities(webUser.getUserName(), "ROLE_USER"));


    }

    @Override
    public User findByUserName(String userName) {
        return userRepository.findUserByUserName(userName);
    }



}
