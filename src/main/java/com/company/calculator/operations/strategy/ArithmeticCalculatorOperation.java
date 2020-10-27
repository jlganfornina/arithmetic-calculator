package com.company.calculator.operations.strategy;

import java.math.BigDecimal;

public interface ArithmeticCalculatorOperation {
    /**
     * Devuelve un número cuyo valor es el resultado de ejecutar la operación sobre {@code firstTerm} y {@code secondTerm}
     *
     * @param firstTerm  primer número para realizar la operación
     * @param secondTerm segundo número para realizar la operación
     * @return Resultado de la operación
     */
    BigDecimal execute(BigDecimal firstTerm,
                       BigDecimal secondTerm);
}
