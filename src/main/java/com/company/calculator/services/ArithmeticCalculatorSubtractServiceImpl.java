package com.company.calculator.services;

import java.math.BigInteger;

public class ArithmeticCalculatorSubtractServiceImpl implements ArithmeticCalculatorSubtractService {
    @Override
    public BigInteger subtract(final BigInteger firstTerm,
                               final BigInteger secondTerm) {
        return firstTerm.subtract(secondTerm);
    }
}
