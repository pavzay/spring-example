package com.github.pavzay.spring.mvc.example.service;

import com.github.pavzay.spring.mvc.example.domain.Order;
import com.github.pavzay.spring.mvc.example.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public Collection<Order> getAll(String username) {
        return orderRepository.getAll(username);
    }

    public Optional<Order> get(String username, Long id) {
        return orderRepository.get(username, id);
    }
}
