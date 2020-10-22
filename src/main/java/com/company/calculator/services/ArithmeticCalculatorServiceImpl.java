package com.company.calculator.services;

import com.company.calculator.exceptions.InvalidTermException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Objects;

@Service
public class ArithmeticCalculatorServiceImpl implements ArithmeticCalculatorService {

    @Override
    public BigDecimal addition(final BigDecimal firstTerm,
                               final BigDecimal secondTerm) {
        if (Objects.isNull(firstTerm)) {
            throw new InvalidTermException(InvalidTermException.FIRST_TERM_IS_NULL);
        }

        return firstTerm.add(secondTerm);
    }
}
