package com.github.pavzay.spring.oauth2.server.repository;

import com.github.pavzay.spring.oauth2.server.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> getByUsername(String username);
}
