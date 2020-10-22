package com.company.calculator.services;

import com.company.calculator.exceptions.InvalidTermException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Objects;

@Service
public class ArithmeticCalculatorAdditionServiceImpl implements ArithmeticCalculatorAdditionService {

    @Override
    public BigDecimal addition(final BigDecimal firstTerm,
                               final BigDecimal secondTerm) {
        validateTerm(firstTerm, InvalidTermException.FIRST_TERM_IS_NULL);
        validateTerm(secondTerm, InvalidTermException.SECOND_TERM_IS_NULL);

        return firstTerm.add(secondTerm);
    }

    private void validateTerm(final BigDecimal term,
                              final String messageIfError) {
        if (Objects.isNull(term)) {
            throw new InvalidTermException(messageIfError);
        }
    }
}
