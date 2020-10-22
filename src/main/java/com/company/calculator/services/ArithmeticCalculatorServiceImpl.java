package com.company.calculator.services;

import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class ArithmeticCalculatorServiceImpl implements ArithmeticCalculatorService {

    @Override
    public BigInteger addition(final BigInteger firstTerm,
                               final BigInteger secondTerm) {
        return firstTerm.add(secondTerm);
    }
}
