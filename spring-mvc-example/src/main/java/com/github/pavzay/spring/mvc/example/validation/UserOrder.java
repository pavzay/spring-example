package com.github.pavzay.spring.mvc.example.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UserOrderValidator.class)
public @interface UserOrder {
    String message() default "{javax.validation.constraints.UserOrder.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
