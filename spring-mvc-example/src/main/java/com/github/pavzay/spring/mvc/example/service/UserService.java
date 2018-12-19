package com.github.pavzay.spring.mvc.example.service;

import com.github.pavzay.spring.mvc.example.domain.User;
import com.github.pavzay.spring.mvc.example.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public Collection<User> getAll() {
        return userRepository.getAll();
    }

    public User add(User user) {
        return userRepository.add(user);
    }

    public User remove(User user) {
        return userRepository.remove(user);
    }

    public Optional<User> getByUsername(String username) {
        return userRepository.getByUsername(username);
    }
}
