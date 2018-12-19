package com.github.pavzay.spring.mvc.example.repository;

import com.github.pavzay.spring.mvc.example.domain.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Objects;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class OrderRepository {
    private final UserRepository userRepository;

    public Collection<Order> getAll(String username) {
        return userRepository.getByUsername(username).orElseThrow(RuntimeException::new).getOrders();
    }

    public Optional<Order> get(String username, Long id) {
        Collection<Order> orders = getAll(username);
        for (Order order : orders) {
            if (Objects.equals(id, order.getId())) {
                return Optional.of(order);
            }
        }
        return Optional.empty();
    }
}
