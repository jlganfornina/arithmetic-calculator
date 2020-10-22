package com.company.calculator.services;

import com.company.calculator.exceptions.InvalidOperationTypeException;
import com.company.calculator.exceptions.InvalidTermException;
import com.company.calculator.services.operations.ArithmeticOperationType;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class ArithmeticCalculatorServiceImplTest {

    @Test
    void shouldAddTwoNumbers() {
        // given
        final ArithmeticCalculatorService arithmeticOperationsService = new ArithmeticCalculatorServiceImpl();

        final BigDecimal firstTerm = new BigDecimal(String.valueOf(Math.random()));
        final BigDecimal secondTerm = new BigDecimal(String.valueOf(Math.random()));
        final ArithmeticOperationType arithmeticOperationType = ArithmeticOperationType.ADDITION;
        final BigDecimal expectedResult = firstTerm.add(secondTerm);

        // when
        final BigDecimal result = arithmeticOperationsService.executeOperation(firstTerm, secondTerm, arithmeticOperationType);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void shouldSubtractTwoNumbers() {
        // given
        final ArithmeticCalculatorService arithmeticOperationsService = new ArithmeticCalculatorServiceImpl();

        final BigDecimal firstTerm = new BigDecimal(String.valueOf(Math.random()));
        final BigDecimal secondTerm = new BigDecimal(String.valueOf(Math.random()));
        final ArithmeticOperationType arithmeticOperationType = ArithmeticOperationType.SUBTRACT;
        final BigDecimal expectedResult = firstTerm.subtract(secondTerm);

        // when
        final BigDecimal result = arithmeticOperationsService.executeOperation(firstTerm, secondTerm, arithmeticOperationType);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void shoudGetInvalidTermsExceptionWhenFirstTermIsNull() {
        // given
        final BigDecimal firstTerm = null;
        final BigDecimal secondTerm = new BigDecimal(String.valueOf(Math.random()));
        final ArithmeticOperationType arithmeticOperationType = ArithmeticOperationType.ADDITION;

        final ArithmeticCalculatorService arithmeticCalculatorService = new ArithmeticCalculatorServiceImpl();

        // when
        // then
        assertThatCode(() -> {
            arithmeticCalculatorService.executeOperation(firstTerm, secondTerm, arithmeticOperationType);
        })
                .isExactlyInstanceOf(InvalidTermException.class)
                .hasMessageContaining(InvalidTermException.FIRST_TERM_IS_NULL);
    }

    @Test
    void shoudGetInvalidTermsExceptionWhenSecondTermIsNull() {
        // given
        final BigDecimal firstTerm = new BigDecimal(String.valueOf(Math.random()));
        final BigDecimal secondTerm = null;
        final ArithmeticOperationType arithmeticOperationType = ArithmeticOperationType.ADDITION;

        final ArithmeticCalculatorService arithmeticCalculatorService = new ArithmeticCalculatorServiceImpl();

        // when
        // then
        assertThatCode(() -> arithmeticCalculatorService.executeOperation(firstTerm, secondTerm, arithmeticOperationType))
                .isExactlyInstanceOf(InvalidTermException.class)
                .hasMessageContaining(InvalidTermException.SECOND_TERM_IS_NULL);
    }

    @Test
    void shoudGetInvalidOperationTypeExceptionWhenSecondTermIsNull() {
        // given
        final BigDecimal firstTerm = new BigDecimal(String.valueOf(Math.random()));
        final BigDecimal secondTerm = new BigDecimal(String.valueOf(Math.random()));
        final ArithmeticOperationType arithmeticOperationType = null;

        final ArithmeticCalculatorService arithmeticCalculatorService = new ArithmeticCalculatorServiceImpl();

        // when
        // then
        assertThatCode(() -> arithmeticCalculatorService.executeOperation(firstTerm, secondTerm, arithmeticOperationType))
                .isExactlyInstanceOf(InvalidOperationTypeException.class)
                .hasMessageContaining(InvalidOperationTypeException.ARITHMETIC_OPERATION_NOT_SUPPORTED);
    }
}
