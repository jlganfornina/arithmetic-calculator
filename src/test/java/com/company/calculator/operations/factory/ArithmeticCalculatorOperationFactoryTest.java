package com.company.calculator.operations.factory;

import com.company.calculator.exceptions.InvalidOperationTypeException;
import com.company.calculator.operations.strategy.ArithmeticCalculatorOperation;
import com.company.calculator.operations.strategy.ArithmeticOperationType;
import com.company.calculator.operations.strategy.impl.ArithmeticCalculatorAdditionOperation;
import com.company.calculator.operations.strategy.impl.ArithmeticCalculatorSubtractOperation;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class ArithmeticCalculatorOperationFactoryTest {
    @Test
    void shouldReturnAdditionStrategy() {
        // given
        final ArithmeticCalculatorOperationFactory arithmeticOperationFactory = new ArithmeticCalculatorOperationFactory();

        // when
        final ArithmeticCalculatorOperation strategy = arithmeticOperationFactory.getStrategy(
                ArithmeticOperationType.ADDITION);

        // then
        assertThat(strategy).isExactlyInstanceOf(ArithmeticCalculatorAdditionOperation.class);
    }

    @Test
    void shouldReturnSubtractStrategy() {
        // given
        final ArithmeticCalculatorOperationFactory arithmeticOperationFactory = new ArithmeticCalculatorOperationFactory();

        // when
        final ArithmeticCalculatorOperation strategy = arithmeticOperationFactory.getStrategy(
                ArithmeticOperationType.SUBTRACT);

        // then
        assertThat(strategy).isExactlyInstanceOf(ArithmeticCalculatorSubtractOperation.class);
    }

    @Test
    void shouldThrowInvalidArithmeticOperationExceptionWhenArithmeticOperationTypeIsNull() {
        // given
        final ArithmeticCalculatorOperationFactory arithmeticOperationFactory = new ArithmeticCalculatorOperationFactory();

        // when
        // then
        assertThatCode(() -> arithmeticOperationFactory.getStrategy(null))
                .isExactlyInstanceOf(InvalidOperationTypeException.class)
                .hasMessageContaining(InvalidOperationTypeException.ARITHMETIC_OPERATION_NOT_SUPPORTED);
    }
}
