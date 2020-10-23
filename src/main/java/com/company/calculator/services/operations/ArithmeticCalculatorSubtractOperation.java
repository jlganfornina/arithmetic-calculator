package com.company.calculator.services.operations;

import java.math.BigDecimal;

public class ArithmeticCalculatorSubtractOperation implements ArithmeticCalculatorOperation {
    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal execute(final BigDecimal firstTerm,
                              final BigDecimal secondTerm) {
        return firstTerm.subtract(secondTerm);
    }
}
