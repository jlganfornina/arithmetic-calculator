package com.company.calculator.services;

import java.math.BigDecimal;

public class ArithmeticCalculatorSubtractServiceImpl implements ArithmeticCalculatorSubtractService {
    @Override
    public BigDecimal subtract(final BigDecimal firstTerm,
                               final BigDecimal secondTerm) {
        return firstTerm.subtract(secondTerm);
    }
}
