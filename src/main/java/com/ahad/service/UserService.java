package com.ahad.service;

import com.ahad.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User addUser(User user);

    Optional<User> getUserById(String id);

    List<User> getAllUsers();

    User updateUser(String id, User user);

    void removeUser(String id);
}
