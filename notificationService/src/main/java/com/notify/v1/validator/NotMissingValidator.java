package com.notify.v1.validator;

import com.notify.v1.annotation.NotMissing;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Collection;

public class NotMissingValidator implements ConstraintValidator<NotMissing, Object> {

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        return switch (value) {
            case null -> false;
            case String stringVal -> !stringVal.trim().isEmpty() || !stringVal.trim().isBlank();
            case Collection<?> collectionVal -> !collectionVal.isEmpty();
            default -> true;
        };
    }
}
