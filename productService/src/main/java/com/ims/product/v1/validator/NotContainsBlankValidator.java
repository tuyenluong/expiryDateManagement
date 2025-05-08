package com.ims.product.v1.validator;

import com.ims.product.v1.annotation.NotContainsBlank;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NotContainsBlankValidator implements ConstraintValidator<NotContainsBlank, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return !value.contains(" ");
    }
}
