package com.company.calculator.services;

import com.company.calculator.exceptions.InvalidTermException;
import com.company.calculator.operations.factory.ArithmeticCalculatorOperationFactory;
import com.company.calculator.operations.strategy.ArithmeticCalculatorOperation;
import com.company.calculator.operations.strategy.ArithmeticOperationType;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ArithmeticCalculatorServiceImplTest {

    @Test
    void shouldAddTwoNumbers() {
        // given
        final ArithmeticOperationType arithmeticOperationType = ArithmeticOperationType.ADDITION;

        final ArithmeticCalculatorOperation mockedArithmeticOperation = mock(ArithmeticCalculatorOperation.class);
        final ArithmeticCalculatorOperationFactory mockedFactory = mock(ArithmeticCalculatorOperationFactory.class);
        when(mockedFactory.getStrategy(arithmeticOperationType)).thenReturn(mockedArithmeticOperation);

        final ArithmeticCalculatorService arithmeticOperationsService = new ArithmeticCalculatorServiceImpl(
                mockedFactory);

        final BigDecimal firstTerm = new BigDecimal(String.valueOf(Math.random()));
        final BigDecimal secondTerm = new BigDecimal(String.valueOf(Math.random()));

        // when
        arithmeticOperationsService.executeOperation(firstTerm, secondTerm, arithmeticOperationType);

        // then
        verify(mockedFactory, only()).getStrategy(arithmeticOperationType);
        verify(mockedArithmeticOperation, only()).execute(firstTerm, secondTerm);
    }

    @Test
    void shouldSubtractTwoNumbers() {
        // given
        final ArithmeticOperationType arithmeticOperationType = ArithmeticOperationType.SUBTRACT;

        final ArithmeticCalculatorOperation mockedArithmeticOperation = mock(ArithmeticCalculatorOperation.class);
        final ArithmeticCalculatorOperationFactory mockedFactory = mock(ArithmeticCalculatorOperationFactory.class);
        when(mockedFactory.getStrategy(arithmeticOperationType)).thenReturn(mockedArithmeticOperation);

        final ArithmeticCalculatorService arithmeticOperationsService = new ArithmeticCalculatorServiceImpl(
                mockedFactory);

        final BigDecimal firstTerm = new BigDecimal(String.valueOf(Math.random()));
        final BigDecimal secondTerm = new BigDecimal(String.valueOf(Math.random()));

        // when
        arithmeticOperationsService.executeOperation(firstTerm, secondTerm, arithmeticOperationType);

        // then
        verify(mockedFactory, only()).getStrategy(arithmeticOperationType);
        verify(mockedArithmeticOperation, only()).execute(firstTerm, secondTerm);
    }

    @Test
    void shoudGetInvalidTermsExceptionWhenFirstTermIsNull() {
        // given
        final BigDecimal firstTerm = null;
        final BigDecimal secondTerm = new BigDecimal(String.valueOf(Math.random()));
        final ArithmeticOperationType arithmeticOperationType = ArithmeticOperationType.ADDITION;
        final ArithmeticCalculatorOperationFactory mockedArithmeticCalculatorOperationFactory = mock(ArithmeticCalculatorOperationFactory.class);

        final ArithmeticCalculatorService arithmeticCalculatorService = new ArithmeticCalculatorServiceImpl(mockedArithmeticCalculatorOperationFactory);

        // when
        // then
        assertThatCode(() -> arithmeticCalculatorService.executeOperation(firstTerm, secondTerm, arithmeticOperationType))
                .isExactlyInstanceOf(InvalidTermException.class)
                .hasMessageContaining(InvalidTermException.FIRST_TERM_IS_NULL);
    }

    @Test
    void shoudGetInvalidTermsExceptionWhenSecondTermIsNull() {
        // given
        final BigDecimal firstTerm = new BigDecimal(String.valueOf(Math.random()));
        final BigDecimal secondTerm = null;
        final ArithmeticOperationType arithmeticOperationType = ArithmeticOperationType.ADDITION;
        final ArithmeticCalculatorOperationFactory mockedArithmeticCalculatorOperationFactory = mock(ArithmeticCalculatorOperationFactory.class);

        final ArithmeticCalculatorService arithmeticCalculatorService = new ArithmeticCalculatorServiceImpl(mockedArithmeticCalculatorOperationFactory);

        // when
        // then
        assertThatCode(() -> arithmeticCalculatorService.executeOperation(firstTerm, secondTerm, arithmeticOperationType))
                .isExactlyInstanceOf(InvalidTermException.class)
                .hasMessageContaining(InvalidTermException.SECOND_TERM_IS_NULL);
    }
}
