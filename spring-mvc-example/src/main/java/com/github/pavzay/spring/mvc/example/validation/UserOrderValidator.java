package com.github.pavzay.spring.mvc.example.validation;

import com.github.pavzay.spring.mvc.example.service.OrderService;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraintvalidation.SupportedValidationTarget;
import javax.validation.constraintvalidation.ValidationTarget;

@SupportedValidationTarget(ValidationTarget.PARAMETERS)
@RequiredArgsConstructor
public class UserOrderValidator implements ConstraintValidator<UserOrder, Object[]> {

    private final OrderService orderService;

    @Override
    public boolean isValid(Object[] value, ConstraintValidatorContext context) {

        if (value.length != 2) {
            throw new IllegalArgumentException("Illegal method signature");
        }

        if (!(value[0] instanceof String) || !(value[1] instanceof Long)) {
            throw new IllegalArgumentException(
                "Illegal method signature, expected first parameter of type String and second parameter of type Long."
            );
        }

        return orderService.get((String) value[0], (Long) value[1]).isPresent();
    }
}
