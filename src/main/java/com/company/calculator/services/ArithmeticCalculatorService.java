package com.company.calculator.services;

import java.math.BigInteger;

public interface ArithmeticCalculatorService {
    /**
     * Devuelve un número cuyo valor es {@code firstTerm + secondTerm}
     *
     * @param firstTerm  primer número para realizar la suma
     * @param secondTerm segundo número para realizar la suma
     * @return {@code firstTerm + secondTerm}
     */
    BigInteger addition(BigInteger firstTerm,
                        BigInteger secondTerm);
}
