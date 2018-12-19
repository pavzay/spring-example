package com.github.pavzay.spring.mvc.example.repository;

import com.github.pavzay.spring.mvc.example.domain.Order;
import com.github.pavzay.spring.mvc.example.domain.User;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class UserRepository {
    private Map<String, User> users;

    {
        users = new HashMap<>();
        List<Order> orders = Arrays.asList(new Order(1L, LocalDateTime.now()), new Order(2L, LocalDateTime.now()));
        users.put("user", new User("user", "user@test.com", "test!", orders));
        orders = Arrays.asList(new Order(3L, LocalDateTime.now()), new Order(4L, LocalDateTime.now()));
        users.put("john", new User("john", "john@test.com", "test!", orders));
    }

    public Collection<User> getAll() {
        return users.values();
    }

    public User add(User user) {
        users.put(user.getUsername(), user);
        return user;
    }

    public User remove(User user) {
        users.remove(user.getUsername());
        return user;
    }

    public Optional<User> getByUsername(String username) {
        return Optional.ofNullable(users.get(username));
    }


}
