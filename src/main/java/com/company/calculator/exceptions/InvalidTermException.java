package com.company.calculator.exceptions;

public class InvalidTermException extends RuntimeException {
    public static final String FIRST_TERM_IS_NULL = "First term cannot be null";
    public static final String SECOND_TERM_IS_NULL = "Second term cannot be null";

    public InvalidTermException(final String message) {
        super(message);
    }
}
