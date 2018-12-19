package com.github.pavzay.spring.mvc.example.controller;

import com.github.pavzay.spring.mvc.example.domain.User;
import com.github.pavzay.spring.mvc.example.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public Collection<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{username}")
    public ResponseEntity<User> get(@PathVariable String username) {
        return userService.getByUsername(username)
            .map(u -> new ResponseEntity<>(u, HttpStatus.OK))
            .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<User> add(@RequestBody @Valid User user) {
        return new ResponseEntity<>(userService.add(user), HttpStatus.CREATED);
    }

    @DeleteMapping
    public User remove(User user) {
        return userService.remove(user);
    }

}
