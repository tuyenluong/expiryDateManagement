package com.ims.product.v1.annotation;

import com.ims.product.v1.validator.NotMissingValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;

@Target(FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NotMissingValidator.class)
public @interface NotContainsBlank {

    String message() default "Field must not contains BLANK spaces";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
