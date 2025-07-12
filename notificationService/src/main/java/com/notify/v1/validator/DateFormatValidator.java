package com.notify.v1.validator;

import com.notify.v1.annotation.DateFormat;
import com.notify.v1.utils.DateManagement;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DateFormatValidator implements ConstraintValidator<DateFormat, String> {

    private String pattern;

    @Override
    public void initialize(DateFormat constraintAnnotation) {
        this.pattern = constraintAnnotation.pattern();
    }

    @Override
    public boolean isValid(String object, ConstraintValidatorContext constraintContext) {
        return DateManagement.validateDateFormat(object,pattern);
    }
}
