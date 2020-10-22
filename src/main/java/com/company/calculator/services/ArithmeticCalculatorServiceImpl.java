package com.company.calculator.services;

import com.company.calculator.exceptions.InvalidOperationTypeException;
import com.company.calculator.exceptions.InvalidTermException;
import com.company.calculator.services.operations.ArithmeticCalculatorAdditionOperation;
import com.company.calculator.services.operations.ArithmeticCalculatorSubtractOperation;
import com.company.calculator.services.operations.ArithmeticOperationType;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Objects;

@Service
public class ArithmeticCalculatorServiceImpl implements ArithmeticCalculatorService {
    @Override
    public BigDecimal executeOperation(final BigDecimal firstTerm,
                                       final BigDecimal secondTerm,
                                       final ArithmeticOperationType arithmeticOperationType) {
        validateTerm(firstTerm, InvalidTermException.FIRST_TERM_IS_NULL);
        validateTerm(secondTerm, InvalidTermException.SECOND_TERM_IS_NULL);
        validateOperationType(arithmeticOperationType);

        switch (arithmeticOperationType) {
            case ADDITION:
                final ArithmeticCalculatorAdditionOperation arithmeticCalculatorAdditionOperation = new ArithmeticCalculatorAdditionOperation();
                return arithmeticCalculatorAdditionOperation.execute(firstTerm, secondTerm);
            case SUBTRACT:
                final ArithmeticCalculatorSubtractOperation arithmeticCalculatorSubtractOperation = new ArithmeticCalculatorSubtractOperation();
                return arithmeticCalculatorSubtractOperation.execute(firstTerm, secondTerm);
            default:
                throw new InvalidOperationTypeException();
        }
    }

    private void validateTerm(final BigDecimal term,
                              final String messageIfError) {
        if (Objects.isNull(term)) {
            throw new InvalidTermException(messageIfError);
        }
    }

    private void validateOperationType(final ArithmeticOperationType arithmeticOperationType) {
        if (Objects.isNull(arithmeticOperationType)) {
            throw new InvalidOperationTypeException();
        }
    }
}
