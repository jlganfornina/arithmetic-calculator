package com.company.calculator.services;

import com.company.calculator.operations.strategy.ArithmeticOperationType;

import java.math.BigDecimal;

public interface ArithmeticCalculatorService {
    /**
     * Devuelve un número cuyo valor es el resultado de ejecutar la operación sobre {@code firstTerm} y {@code secondTerm}
     *
     * @param firstTerm               primer número para realizar la operación
     * @param secondTerm              segundo número para realizar la operación
     * @param arithmeticOperationType tipo de operación a realizar
     * @return {@code firstTerm} ({@code arithmeticOperationType}) {@code secondTerm}
     */
    BigDecimal executeOperation(BigDecimal firstTerm,
                                BigDecimal secondTerm,
                                ArithmeticOperationType arithmeticOperationType);
}
