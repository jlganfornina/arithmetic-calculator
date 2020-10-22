package com.company.calculator.services;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ArithmeticCalculatorServiceImpl implements ArithmeticCalculatorService {

    @Override
    public BigDecimal addition(final BigDecimal firstTerm,
                               final BigDecimal secondTerm) {
        return firstTerm.add(secondTerm);
    }
}
