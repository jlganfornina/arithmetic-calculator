package com.company.calculator.services;

import com.company.calculator.exceptions.InvalidTermException;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class ArithmeticCalculatorAdditionServiceImplTest {

    @Test
    void shouldAddTwoNumbersWithoutDecimals() {
        // given
        final BigDecimal firstTerm = new BigDecimal("5667");
        final BigDecimal secondTerm = new BigDecimal("45");
        final BigDecimal expectedResult = new BigDecimal("5712");

        final ArithmeticCalculatorAdditionService arithmeticCalculatorService = new ArithmeticCalculatorAdditionServiceImpl();

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

        final ArithmeticCalculatorAdditionService arithmeticCalculatorService = new ArithmeticCalculatorAdditionServiceImpl();

        // when
        final BigDecimal result = arithmeticCalculatorService.addition(firstTerm, secondTerm);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void shouldAddTwoNumbersWithLargeNumberOfDecimals() {
        // given
        final BigDecimal firstTerm = new BigDecimal("657867845.23498437534985673459857349857239845767854764587364387563487534698756349857348957345765498252");
        final BigDecimal secondTerm = new BigDecimal("49695.76785476458736438756348753469875634985734895734576549825223498437534985673459857349857239845");
        final BigDecimal expectedResult = new BigDecimal("657917541.00283913993722112216206103327115480753589660321940937388711033136291335530808814695622738097");

        final ArithmeticCalculatorAdditionService arithmeticCalculatorService = new ArithmeticCalculatorAdditionServiceImpl();

        // when
        final BigDecimal result = arithmeticCalculatorService.addition(firstTerm, secondTerm);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void shouldAddTwoRandomNumbers() {
        // given
        final BigDecimal firstTerm = new BigDecimal(String.valueOf(Math.random()));
        final BigDecimal secondTerm = new BigDecimal(String.valueOf(Math.random()));
        final BigDecimal expectedResult = firstTerm.add(secondTerm);

        final ArithmeticCalculatorAdditionService arithmeticCalculatorService = new ArithmeticCalculatorAdditionServiceImpl();

        // when
        final BigDecimal result = arithmeticCalculatorService.addition(firstTerm, secondTerm);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void shouldAddTwoNumbersWithRepeatedDecimalsAndGetCorrectResult() {
        // given
        final BigDecimal firstTerm = new BigDecimal("1.99999999999999999999999999999999");
        final BigDecimal secondTerm = new BigDecimal("1.00000000000000000000000000000001");
        final BigDecimal expectedResult = new BigDecimal("3.00000000000000000000000000000000");

        final ArithmeticCalculatorAdditionService arithmeticCalculatorService = new ArithmeticCalculatorAdditionServiceImpl();

        // when
        final BigDecimal result = arithmeticCalculatorService.addition(firstTerm, secondTerm);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void shouldAddTwoNegativeNumbers() {
        // given
        final BigDecimal firstTerm = new BigDecimal("-11.234234");
        final BigDecimal secondTerm = new BigDecimal("-23.3434345");
        final BigDecimal expectedResult = new BigDecimal("-34.5776685");

        final ArithmeticCalculatorAdditionService arithmeticCalculatorService = new ArithmeticCalculatorAdditionServiceImpl();

        // when
        final BigDecimal result = arithmeticCalculatorService.addition(firstTerm, secondTerm);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void shoudGetInvalidTermsExceptionWhenFirstTermIsNull() {
        // given
        final BigDecimal firstTerm = null;
        final BigDecimal secondTerm = new BigDecimal(String.valueOf(Math.random()));

        final ArithmeticCalculatorAdditionService arithmeticCalculatorService = new ArithmeticCalculatorAdditionServiceImpl();

        // when
        // then
        assertThatCode(() -> arithmeticCalculatorService.addition(firstTerm, secondTerm))
                .isExactlyInstanceOf(InvalidTermException.class)
                .hasMessageContaining(InvalidTermException.FIRST_TERM_IS_NULL);
    }

    @Test
    void shoudGetInvalidTermsExceptionWhenSecondTermIsNull() {
        // given
        final BigDecimal firstTerm = new BigDecimal(String.valueOf(Math.random()));
        final BigDecimal secondTerm = null;

        final ArithmeticCalculatorAdditionService arithmeticCalculatorService = new ArithmeticCalculatorAdditionServiceImpl();

        // when
        // then
        assertThatCode(() -> arithmeticCalculatorService.addition(firstTerm, secondTerm))
                .isExactlyInstanceOf(InvalidTermException.class)
                .hasMessageContaining(InvalidTermException.SECOND_TERM_IS_NULL);
    }
}
