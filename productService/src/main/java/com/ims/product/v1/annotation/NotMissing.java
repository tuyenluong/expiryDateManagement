package com.ims.product.v1.annotation;

import com.ims.product.v1.validator.NotMissingValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

@Target(FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NotMissingValidator.class)
public @interface NotMissing {

    String message() default "Field must not NULL, EMPTY or BLANK";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
