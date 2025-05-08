package com.ims.product.v1.validator;

import com.ims.product.v1.annotation.NotContainsSpace;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NotContainsSpaceValidator implements ConstraintValidator<NotContainsSpace, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return !value.contains(" ");
    }
}
