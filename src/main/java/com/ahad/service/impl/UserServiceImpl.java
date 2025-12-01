package com.ahad.service.impl;

import com.ahad.model.User;
import com.ahad.repository.UserRepository;
import com.ahad.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User addUser(User user) {
        // Ensure JPA treats this as a new entity — do not set id manually
        user.setId(null);
        return userRepository.save(user);
    }

    @Override
    public Optional<User> getUserById(UUID id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(UUID id, User user) {
        return userRepository.findById(id)
                .map(existing -> {
                    existing.setName(user.getName());
                    existing.setEmail(user.getEmail());
                    existing.setPassword(user.getPassword());
                    existing.setIsEnable(user.getIsEnable());
                    return userRepository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("User not found: " + id));
    }

    @Override
    public void removeUser(UUID id) {
        userRepository.deleteById(id);
    }
}
