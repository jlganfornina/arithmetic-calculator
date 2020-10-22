package com.company.calculator.services;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class ArithmeticCalculatorServiceImplTest {

    @Test
    void shouldAddTwoNumbersWithoutDecimals() {
        // given
        final BigDecimal firstTerm = new BigDecimal("5667");
        final BigDecimal secondTerm = new BigDecimal("45");
        final BigDecimal expectedResult = new BigDecimal("5712");

        final ArithmeticCalculatorServiceImpl arithmeticCalculatorService = new ArithmeticCalculatorServiceImpl();

        // when
        final BigDecimal result = arithmeticCalculatorService.addition(firstTerm, secondTerm);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void shouldAddTwoNumbersWithDecimals() {
        // given
        final BigDecimal firstTerm = new BigDecimal("5667.4545");
        final BigDecimal secondTerm = new BigDecimal("45.7676");
        final BigDecimal expectedResult = new BigDecimal("5713.2221");

        final ArithmeticCalculatorServiceImpl arithmeticCalculatorService = new ArithmeticCalculatorServiceImpl();

        // when
        final BigDecimal result = arithmeticCalculatorService.addition(firstTerm, secondTerm);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }
}
