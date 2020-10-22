package com.company.calculator.services.operations;

import com.company.calculator.exceptions.InvalidOperationTypeException;
import org.springframework.stereotype.Component;

import java.util.EnumMap;
import java.util.Map;

@Component
public class ArithmeticCalculatorOperationFactory {
    private final Map<ArithmeticOperationType, ArithmeticCalculatorOperation> arithmeticOperationsStrategies =
            new EnumMap<>(ArithmeticOperationType.class);

    public ArithmeticCalculatorOperationFactory() {
        initializeStrategies();
    }

    private void initializeStrategies() {
        arithmeticOperationsStrategies.put(ArithmeticOperationType.ADDITION,
                new ArithmeticCalculatorAdditionOperation());
        arithmeticOperationsStrategies.put(ArithmeticOperationType.SUBTRACT,
                new ArithmeticCalculatorSubtractOperation());
    }

    /**
     * Devuelve la estrategia correcta para la operación requerida
     *
     * @param arithmeticOperationType tipo de operación
     * @return {@code ArithmeticCalculatorOperation que realiza la operación requerida}
     */
    public ArithmeticCalculatorOperation getStrategy(final ArithmeticOperationType arithmeticOperationType) {
        if (arithmeticOperationType == null || !arithmeticOperationsStrategies.containsKey(arithmeticOperationType)) {
            throw new InvalidOperationTypeException();
        }

        return arithmeticOperationsStrategies.get(arithmeticOperationType);
    }
}
