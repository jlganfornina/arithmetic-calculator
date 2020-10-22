package com.company.calculator.services.operations;

import java.math.BigDecimal;

public class ArithmeticCalculatorSubtractOperation implements ArithmeticCalculatorOperation {
    @Override
    public BigDecimal execute(final BigDecimal firstTerm,
                              final BigDecimal secondTerm) {
        return firstTerm.subtract(secondTerm);
    }
}
