package com.company.calculator.services.operations;

import java.math.BigDecimal;

public interface ArithmeticCalculatorOperation {
    /**
     * Devuelve un número cuyo valor es {@code firstTerm + secondTerm}
     *
     * @param firstTerm  primer número para realizar la suma
     * @param secondTerm segundo número para realizar la suma
     * @return {@code firstTerm + secondTerm}
     */
    BigDecimal execute(BigDecimal firstTerm,
                       BigDecimal secondTerm);
}
