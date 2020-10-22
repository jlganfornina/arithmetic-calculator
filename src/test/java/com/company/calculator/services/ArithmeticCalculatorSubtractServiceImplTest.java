package com.company.calculator.services;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.assertj.core.api.Assertions.assertThat;

class ArithmeticCalculatorSubtractServiceImplTest {

    @Test
    void shouldSubtractTwoNumbersWithoutDecimals() {
        // given
        final BigInteger firstTerm = new BigInteger("5667");
        final BigInteger secondTerm = new BigInteger("45");
        final BigInteger expectedResult = new BigInteger("5622");

        final ArithmeticCalculatorSubtractService arithmeticCalculatorService = new ArithmeticCalculatorSubtractServiceImpl();

        // when
        final BigInteger result = arithmeticCalculatorService.subtract(firstTerm, secondTerm);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }
}
