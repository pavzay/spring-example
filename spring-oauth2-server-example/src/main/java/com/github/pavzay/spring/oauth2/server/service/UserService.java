package com.github.pavzay.spring.oauth2.server.service;

import com.github.pavzay.spring.oauth2.server.domain.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    void create(User user);
}
