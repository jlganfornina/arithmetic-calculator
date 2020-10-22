package com.company.calculator.services;

import com.company.calculator.exceptions.InvalidTermException;

import java.math.BigDecimal;
import java.util.Objects;

public class ArithmeticCalculatorSubtractServiceImpl implements ArithmeticCalculatorSubtractService {
    @Override
    public BigDecimal subtract(final BigDecimal firstTerm,
                               final BigDecimal secondTerm) {
        if (Objects.isNull(firstTerm)) {
            throw new InvalidTermException(InvalidTermException.FIRST_TERM_IS_NULL);
        }

        return firstTerm.subtract(secondTerm);
    }
}
