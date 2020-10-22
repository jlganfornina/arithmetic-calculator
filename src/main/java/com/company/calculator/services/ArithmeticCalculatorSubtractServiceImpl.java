package com.company.calculator.services;

import com.company.calculator.exceptions.InvalidTermException;

import java.math.BigDecimal;
import java.util.Objects;

public class ArithmeticCalculatorSubtractServiceImpl implements ArithmeticCalculatorSubtractService {
    @Override
    public BigDecimal subtract(final BigDecimal firstTerm,
                               final BigDecimal secondTerm) {
        validateTerm(firstTerm, InvalidTermException.FIRST_TERM_IS_NULL);
        validateTerm(secondTerm, InvalidTermException.SECOND_TERM_IS_NULL);

        return firstTerm.subtract(secondTerm);
    }

    private void validateTerm(final BigDecimal term,
                              final String messageIfError) {
        if (Objects.isNull(term)) {
            throw new InvalidTermException(messageIfError);
        }
    }
}
