package com.example.demo.auth;

import com.example.demo.entity.User;

public interface AuthService {
    int register(User userToAdd);
    String login(String username, String password);
    String refresh(String oldToken);
}


