package com.company.calculator.services.operations;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class ArithmeticCalculatorAdditionOperationTest {

    @Test
    void shouldAddTwoNumbersWithoutDecimals() {
        // given
        final BigDecimal firstTerm = new BigDecimal("5667");
        final BigDecimal secondTerm = new BigDecimal("45");
        final BigDecimal expectedResult = new BigDecimal("5712");

        final ArithmeticCalculatorOperation arithmeticCalculatorService = new ArithmeticCalculatorAdditionOperation();

        // when
        final BigDecimal result = arithmeticCalculatorService.execute(firstTerm, secondTerm);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void shouldAddTwoNumbersWithDecimals() {
        // given
        final BigDecimal firstTerm = new BigDecimal("5667.4545");
        final BigDecimal secondTerm = new BigDecimal("45.7676");
        final BigDecimal expectedResult = new BigDecimal("5713.2221");

        final ArithmeticCalculatorOperation arithmeticCalculatorService = new ArithmeticCalculatorAdditionOperation();

        // when
        final BigDecimal result = arithmeticCalculatorService.execute(firstTerm, secondTerm);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void shouldAddTwoNumbersWithLargeNumberOfDecimals() {
        // given
        final BigDecimal firstTerm = new BigDecimal("657867845.23498437534985673459857349857239845767854764587364387563487534698756349857348957345765498252");
        final BigDecimal secondTerm = new BigDecimal("49695.76785476458736438756348753469875634985734895734576549825223498437534985673459857349857239845");
        final BigDecimal expectedResult = new BigDecimal("657917541.00283913993722112216206103327115480753589660321940937388711033136291335530808814695622738097");

        final ArithmeticCalculatorOperation arithmeticCalculatorService = new ArithmeticCalculatorAdditionOperation();

        // when
        final BigDecimal result = arithmeticCalculatorService.execute(firstTerm, secondTerm);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void shouldAddTwoRandomNumbers() {
        // given
        final BigDecimal firstTerm = new BigDecimal(String.valueOf(Math.random()));
        final BigDecimal secondTerm = new BigDecimal(String.valueOf(Math.random()));
        final BigDecimal expectedResult = firstTerm.add(secondTerm);

        final ArithmeticCalculatorOperation arithmeticCalculatorService = new ArithmeticCalculatorAdditionOperation();

        // when
        final BigDecimal result = arithmeticCalculatorService.execute(firstTerm, secondTerm);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void shouldAddTwoNumbersWithRepeatedDecimalsAndGetCorrectResult() {
        // given
        final BigDecimal firstTerm = new BigDecimal("1.99999999999999999999999999999999");
        final BigDecimal secondTerm = new BigDecimal("1.00000000000000000000000000000001");
        final BigDecimal expectedResult = new BigDecimal("3.00000000000000000000000000000000");

        final ArithmeticCalculatorOperation arithmeticCalculatorService = new ArithmeticCalculatorAdditionOperation();

        // when
        final BigDecimal result = arithmeticCalculatorService.execute(firstTerm, secondTerm);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void shouldAddTwoNegativeNumbers() {
        // given
        final BigDecimal firstTerm = new BigDecimal("-11.234234");
        final BigDecimal secondTerm = new BigDecimal("-23.3434345");
        final BigDecimal expectedResult = new BigDecimal("-34.5776685");

        final ArithmeticCalculatorOperation arithmeticCalculatorService = new ArithmeticCalculatorAdditionOperation();

        // when
        final BigDecimal result = arithmeticCalculatorService.execute(firstTerm, secondTerm);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }
}
