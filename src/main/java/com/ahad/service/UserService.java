package com.ahad.service;

import com.ahad.model.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {

    User addUser(User user);

    Optional<User> getUserById(UUID id);

    List<User> getAllUsers();

    User updateUser(UUID id, User user);

    void removeUser(UUID id);
}
