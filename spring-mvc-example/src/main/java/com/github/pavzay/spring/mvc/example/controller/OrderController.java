package com.github.pavzay.spring.mvc.example.controller;

import com.github.pavzay.spring.mvc.example.domain.Order;
import com.github.pavzay.spring.mvc.example.service.OrderService;
import com.github.pavzay.spring.mvc.example.validation.UserOrder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/users/{username}/orders/")
@RequiredArgsConstructor
@Validated
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    public Collection<Order> getAll(@PathVariable String username) {
        return orderService.getAll(username);
    }

    @GetMapping("/{id}")
    @UserOrder
    public ResponseEntity<Order> getById(@PathVariable String username, @PathVariable Long id) {
        return orderService.get(username, id)
            .map(u -> new ResponseEntity<>(u, HttpStatus.OK))
            .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
