package com.udemy.compras.utils;

import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

public class DateUtils {

    private static final String PATTERN = "yyyy-MM-dd HH:mm:ss";
    private static final DateTimeFormatter FORMATTER = new DateTimeFormatterBuilder().appendPattern(PATTERN).toFormatter();

    @NotNull
    public static String fromDate(@NotNull LocalDateTime ldt) {
        return ldt.format(FORMATTER);
    }

    @NotNull
    public static LocalDateTime fromString(String formatted) {
        try {
            return LocalDateTime.parse(formatted, FORMATTER);
        } catch (Exception ex) {
            return null;
        }
    }

}
