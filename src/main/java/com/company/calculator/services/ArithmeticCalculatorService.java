package com.company.calculator.services;

import com.company.calculator.services.operations.ArithmeticOperationType;

import java.math.BigDecimal;

public interface ArithmeticCalculatorService {
    /**
     * Devuelve un número cuyo valor es el resultado de ejecutar la operación sobre {@code firstTerm} y {@code secondTerm}
     *
     * @param firstTerm  primer número para realizar la suma
     * @param secondTerm segundo número para realizar la suma
     * @return {@code firstTerm} ({@code arithmeticOperationType}) {@code secondTerm}
     */
    BigDecimal executeOperation(BigDecimal firstTerm,
                                BigDecimal secondTerm,
                                ArithmeticOperationType arithmeticOperationType);
}
