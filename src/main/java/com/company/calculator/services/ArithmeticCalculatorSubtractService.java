package com.company.calculator.services;

import java.math.BigDecimal;

public interface ArithmeticCalculatorSubtractService {
    /**
     * Devuelve un número cuyo valor es {@code firstTerm - secondTerm}
     *
     * @param firstTerm  primer número para realizar la resta
     * @param secondTerm segundo número para realizar la resta
     * @return {@code firstTerm - secondTerm}
     */
    BigDecimal subtract(BigDecimal firstTerm,
                        BigDecimal secondTerm);
}
