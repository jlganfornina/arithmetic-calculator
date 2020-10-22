package com.company.calculator.exceptions;

public class InvalidOperationTypeException extends RuntimeException {
    public static final String ARITHMETIC_OPERATION_NOT_SUPPORTED = "Arithmetic operation not supported";

    public InvalidOperationTypeException() {
        super(ARITHMETIC_OPERATION_NOT_SUPPORTED);
    }
}
