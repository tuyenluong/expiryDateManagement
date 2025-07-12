package com.notify.v1.annotation;

import com.notify.v1.validator.NotContainsSpaceValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;

@Target(FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NotContainsSpaceValidator.class)
public @interface NotContainsSpace {

    String message() default "Field must not contains spaces";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
