package com.ims.product.v1.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

public class DateManagement {

    public static boolean validateDateFormat(String date, String pattern){
        if (date == null || date.trim().isEmpty()) {
            // Allow nulls and blanks; use @NotMissing to enforce presence
            return true;
        }
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
            formatter.withResolverStyle(ResolverStyle.STRICT);
            LocalDate.parse(date, formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
}
