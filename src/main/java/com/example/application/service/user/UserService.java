package com.example.application.service.user;

import com.example.application.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User saveUser(User user);

    User getUser(int id);

    void deleteUser(int id);
}
