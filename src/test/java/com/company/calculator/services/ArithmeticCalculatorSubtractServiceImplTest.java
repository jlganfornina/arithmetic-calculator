package com.company.calculator.services;

import com.company.calculator.exceptions.InvalidTermException;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

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

    @Test
    void shouldSubtractTwoNumbersWithLargeNumberOfDecimals() {
        // given
        final BigDecimal firstTerm = new BigDecimal("657867845.23498437534985673459857349857239845767854764587364387563487534698756349857348957345765498252");
        final BigDecimal secondTerm = new BigDecimal("49695.76785476458736438756348753469875634985734895734576549825223498437534985673459857349857239845");
        final BigDecimal expectedResult = new BigDecimal("657818149.46712961076249234703508596387364210782119868852787837738264036261221364183889099995908258407");

        final ArithmeticCalculatorSubtractService arithmeticCalculatorService = new ArithmeticCalculatorSubtractServiceImpl();

        // when
        final BigDecimal result = arithmeticCalculatorService.subtract(firstTerm, secondTerm);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void shouldSubtractTwoRandomNumbers() {
        // given
        final BigDecimal firstTerm = new BigDecimal(String.valueOf(Math.random()));
        final BigDecimal secondTerm = new BigDecimal(String.valueOf(Math.random()));
        final BigDecimal expectedResult = firstTerm.subtract(secondTerm);

        final ArithmeticCalculatorSubtractService arithmeticCalculatorService = new ArithmeticCalculatorSubtractServiceImpl();

        // when
        final BigDecimal result = arithmeticCalculatorService.subtract(firstTerm, secondTerm);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void shouldSubtractTwoNumbersWithRepeatedDecimalsAndGetCorrectResult() {
        // given
        final BigDecimal firstTerm = new BigDecimal("1.99999999999999999999999999999999");
        final BigDecimal secondTerm = new BigDecimal("1.00000000000000000000000000000001");
        final BigDecimal expectedResult = new BigDecimal("0.99999999999999999999999999999998");

        final ArithmeticCalculatorSubtractService arithmeticCalculatorService = new ArithmeticCalculatorSubtractServiceImpl();

        // when
        final BigDecimal result = arithmeticCalculatorService.subtract(firstTerm, secondTerm);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void shouldSubtractTwoNegativeNumbers() {
        // given
        final BigDecimal firstTerm = new BigDecimal("-11.234234");
        final BigDecimal secondTerm = new BigDecimal("-23.3434345");
        final BigDecimal expectedResult = new BigDecimal("12.1092005");

        final ArithmeticCalculatorSubtractService arithmeticCalculatorService = new ArithmeticCalculatorSubtractServiceImpl();

        // when
        final BigDecimal result = arithmeticCalculatorService.subtract(firstTerm, secondTerm);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void shoudGetInvalidTermsExceptionWhenFirstTermIsNull() {
        // given
        final BigDecimal firstTerm = null;
        final BigDecimal secondTerm = new BigDecimal(String.valueOf(Math.random()));

        final ArithmeticCalculatorSubtractService arithmeticCalculatorService = new ArithmeticCalculatorSubtractServiceImpl();

        // when
        // then
        assertThatCode(() -> arithmeticCalculatorService.subtract(firstTerm, secondTerm))
                .isExactlyInstanceOf(InvalidTermException.class)
                .hasMessageContaining(InvalidTermException.FIRST_TERM_IS_NULL);
    }

    @Test
    void shoudGetInvalidTermsExceptionWhenSecondTermIsNull() {
        // given
        final BigDecimal firstTerm = new BigDecimal(String.valueOf(Math.random()));
        final BigDecimal secondTerm = null;

        final ArithmeticCalculatorSubtractService arithmeticCalculatorService = new ArithmeticCalculatorSubtractServiceImpl();

        // when
        // then
        assertThatCode(() -> arithmeticCalculatorService.subtract(firstTerm, secondTerm))
                .isExactlyInstanceOf(InvalidTermException.class)
                .hasMessageContaining(InvalidTermException.SECOND_TERM_IS_NULL);
    }
}
