package com.company.calculator.services;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.assertj.core.api.Assertions.assertThat;

class ArithmeticCalculatorServiceImplTest {

    @Test
    void shouldAddTwoNumbersWithoutDecimals() {
        // given
        final BigInteger firstTerm = new BigInteger("5667");
        final BigInteger secondTerm = new BigInteger("45");
        final BigInteger expectedResult = new BigInteger("5712");

        final ArithmeticCalculatorServiceImpl arithmeticCalculatorService = new ArithmeticCalculatorServiceImpl();

        // when
        final BigInteger result = arithmeticCalculatorService.addition(firstTerm, secondTerm);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }
}
