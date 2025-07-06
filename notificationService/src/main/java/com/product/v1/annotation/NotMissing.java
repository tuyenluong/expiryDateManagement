package com.product.v1.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;

@Target(FIELD)
@Retention(RetentionPolicy.RUNTIME)
@NotNull
@NotEmpty
@NotBlank
@Constraint(validatedBy = {})
public @interface NotMissing {

    String message() default "Field must not NULL, EMPTY or BLANK";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
