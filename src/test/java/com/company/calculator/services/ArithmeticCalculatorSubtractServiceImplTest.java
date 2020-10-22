package com.company.calculator.services;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class ArithmeticCalculatorSubtractServiceImplTest {

    @Test
    void shouldSubtractTwoNumbersWithoutDecimals() {
        // given
        final BigDecimal firstTerm = new BigDecimal("5667");
        final BigDecimal secondTerm = new BigDecimal("45");
        final BigDecimal expectedResult = new BigDecimal("5622");

        final ArithmeticCalculatorSubtractService arithmeticCalculatorService = new ArithmeticCalculatorSubtractServiceImpl();

        // when
        final BigDecimal result = arithmeticCalculatorService.subtract(firstTerm, secondTerm);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void shouldSubtractTwoNumbersWithDecimals() {
        // given
        final BigDecimal firstTerm = new BigDecimal("5667.4545");
        final BigDecimal secondTerm = new BigDecimal("45.7676");
        final BigDecimal expectedResult = new BigDecimal("5621.6869");

        final ArithmeticCalculatorSubtractService arithmeticCalculatorService = new ArithmeticCalculatorSubtractServiceImpl();

        // when
        final BigDecimal result = arithmeticCalculatorService.subtract(firstTerm, secondTerm);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }
}
