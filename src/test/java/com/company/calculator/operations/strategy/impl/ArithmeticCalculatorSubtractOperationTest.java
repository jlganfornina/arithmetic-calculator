package com.company.calculator.operations.strategy.impl;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class ArithmeticCalculatorSubtractOperationTest {

    @Test
    void shouldSubtractTwoNumbersWithoutDecimals() {
        // given
        final BigDecimal firstTerm = new BigDecimal("5667");
        final BigDecimal secondTerm = new BigDecimal("45");
        final BigDecimal expectedResult = new BigDecimal("5622");

        final ArithmeticCalculatorSubtractOperation arithmeticCalculatorService = new ArithmeticCalculatorSubtractOperation();

        // when
        final BigDecimal result = arithmeticCalculatorService.execute(firstTerm, secondTerm);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void shouldSubtractTwoNumbersWithDecimals() {
        // given
        final BigDecimal firstTerm = new BigDecimal("5667.4545");
        final BigDecimal secondTerm = new BigDecimal("45.7676");
        final BigDecimal expectedResult = new BigDecimal("5621.6869");

        final ArithmeticCalculatorSubtractOperation arithmeticCalculatorService = new ArithmeticCalculatorSubtractOperation();

        // when
        final BigDecimal result = arithmeticCalculatorService.execute(firstTerm, secondTerm);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void shouldSubtractTwoNumbersWithLargeNumberOfDecimals() {
        // given
        final BigDecimal firstTerm = new BigDecimal("657867845.23498437534985673459857349857239845767854764587364387563487534698756349857348957345765498252");
        final BigDecimal secondTerm = new BigDecimal("49695.76785476458736438756348753469875634985734895734576549825223498437534985673459857349857239845");
        final BigDecimal expectedResult = new BigDecimal("657818149.46712961076249234703508596387364210782119868852787837738264036261221364183889099995908258407");

        final ArithmeticCalculatorSubtractOperation arithmeticCalculatorService = new ArithmeticCalculatorSubtractOperation();

        // when
        final BigDecimal result = arithmeticCalculatorService.execute(firstTerm, secondTerm);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void shouldSubtractTwoRandomNumbers() {
        // given
        final BigDecimal firstTerm = new BigDecimal(String.valueOf(Math.random()));
        final BigDecimal secondTerm = new BigDecimal(String.valueOf(Math.random()));
        final BigDecimal expectedResult = firstTerm.subtract(secondTerm);

        final ArithmeticCalculatorSubtractOperation arithmeticCalculatorService = new ArithmeticCalculatorSubtractOperation();

        // when
        final BigDecimal result = arithmeticCalculatorService.execute(firstTerm, secondTerm);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void shouldSubtractTwoNumbersWithRepeatedDecimalsAndGetCorrectResult() {
        // given
        final BigDecimal firstTerm = new BigDecimal("1.99999999999999999999999999999999");
        final BigDecimal secondTerm = new BigDecimal("1.00000000000000000000000000000001");
        final BigDecimal expectedResult = new BigDecimal("0.99999999999999999999999999999998");

        final ArithmeticCalculatorSubtractOperation arithmeticCalculatorService = new ArithmeticCalculatorSubtractOperation();

        // when
        final BigDecimal result = arithmeticCalculatorService.execute(firstTerm, secondTerm);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void shouldSubtractTwoNegativeNumbers() {
        // given
        final BigDecimal firstTerm = new BigDecimal("-11.234234");
        final BigDecimal secondTerm = new BigDecimal("-23.3434345");
        final BigDecimal expectedResult = new BigDecimal("12.1092005");

        final ArithmeticCalculatorSubtractOperation arithmeticCalculatorService = new ArithmeticCalculatorSubtractOperation();

        // when
        final BigDecimal result = arithmeticCalculatorService.execute(firstTerm, secondTerm);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }
}
