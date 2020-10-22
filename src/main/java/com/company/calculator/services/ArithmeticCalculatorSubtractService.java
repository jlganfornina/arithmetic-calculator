package com.company.calculator.services;

import java.math.BigInteger;

public interface ArithmeticCalculatorSubtractService {
    /**
     * Devuelve un número cuyo valor es {@code firstTerm - secondTerm}
     *
     * @param firstTerm  primer número para realizar la resta
     * @param secondTerm segundo número para realizar la resta
     * @return {@code firstTerm - secondTerm}
     */
    BigInteger subtract(BigInteger firstTerm,
                        BigInteger secondTerm);
}
