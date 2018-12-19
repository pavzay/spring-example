package com.github.pavzay.spring.mvc.example.domain;

import com.github.pavzay.spring.mvc.example.validation.Password;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @NotEmpty
    @Size(min = 3)
    private String username;
    @NotEmpty
    @Email(message = "{email.correct.message}")
    private String email;
    @Password
    private String password;
    private Collection<Order> orders;
}
