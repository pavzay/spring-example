package com.github.pavzay.spring.mvc.example.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;

public class PasswordValidator implements ConstraintValidator<Password, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (Objects.nonNull(value) && value.length() >= 8) {

            boolean containsSpace = false;
            boolean containsNumeric = false;

            for (int i = 0; i < value.length(); i++) {
                char c = value.charAt(i);
                containsSpace = containsSpace || (c == ' ');
                containsNumeric = containsNumeric || (c >= '0' && c <= '9');
            }

            return !containsSpace && containsNumeric;
        }

        return false;
    }

}
