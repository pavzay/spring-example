package com.github.pavzay.spring.oauth2.server.service;

import com.github.pavzay.spring.oauth2.server.domain.User;
import com.github.pavzay.spring.oauth2.server.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service("userDetailsService")
@RequiredArgsConstructor
public class DatabaseUserService implements UserService {

    private static final BCryptPasswordEncoder B_CRYPT_PASSWORD_ENCODER = new BCryptPasswordEncoder();

    private final UserRepository userRepository;

    @Override
    public void create(User user) {
        if (userRepository.getByUsername(user.getUsername()).isPresent()) {
            throw new RuntimeException("User already exists: " + user.getUsername());
        }

        user.setPassword(B_CRYPT_PASSWORD_ENCODER.encode(user.getPassword()));

        userRepository.save(user);

        log.info("New user has been created: {}", user.getUsername());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails user = userRepository.getByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username));

        log.info("User found " + user);

        return user;

    }
}

